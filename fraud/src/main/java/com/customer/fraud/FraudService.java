package com.customer.fraud;

import org.springframework.stereotype.Service;

@Service
public interface FraudService {

    boolean isFraudulentCustomer(Long customerId);

}
