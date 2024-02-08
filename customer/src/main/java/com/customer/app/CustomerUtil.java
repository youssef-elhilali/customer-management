package com.customer.app;

public class CustomerUtil {

    protected static Customer toCustomer (CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();
    }

    protected static CustomerDto toDto (Customer customer) {
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

}
