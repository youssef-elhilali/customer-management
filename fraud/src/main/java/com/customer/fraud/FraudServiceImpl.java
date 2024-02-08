package com.customer.fraud;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FraudServiceImpl implements FraudService {

    private final FraudRepository fraudRepository;

    public FraudServiceImpl(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }
    @Override
    public boolean isFraudulentCustomer(Long customerId) {
        try {
            Fraud fraud = Fraud.builder()
                            .customerId(customerId)
                                    .createdAt(LocalDateTime.now())
                                            .isFraudster(false)
                                                    .build();
            this.fraudRepository.save(fraud);
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Fraud not added");
        }
    }

}
