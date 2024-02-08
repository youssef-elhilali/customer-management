package com.customer.app;

import com.customer.client.fraud.FraudClient;
import com.customer.client.fraud.FraudDto;
import com.customer.client.notification.NotificationClient;
import com.customer.client.notification.NotificationDto;
import com.customer.message_queue.RabbitMQMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Override
    public ResponseEntity<?> saveCustomer(CustomerDto customerDto) {
        log.info("CustomerDto : {}", customerDto);
        Customer customer = CustomerUtil.toCustomer(customerDto);
        log.info("Customer : {}", customer);
        this.customerRepository.saveAndFlush(customer);
        FraudDto fraudDto = fraudClient.isFraudster(customer.getId());
        if (fraudDto.isFraudster()) {
            throw new IllegalStateException("Fraudtster");
        }
        // todo: send notification

        NotificationDto notificationDto = NotificationDto.builder()
                .customerId(customer.getId())
                .customerEmail(customer.getEmail())
                .message("Customer with name " + customer.getFirstName() + " " + customer.getLastName() + " with email " + customer.getEmail() + " is fraudster")
                .build();

        this.rabbitMQMessageProducer.send(
                notificationDto,
                "internal.exchange",
                "internal.notification.routing-key"
        );
        
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        return customers.stream().map(CustomerUtil::toDto).collect(Collectors.toList());
    }
}
