package com.customer.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping(path = "api/frauds/{customerId}")
    FraudDto isFraudster (@PathVariable("customerId") Long customerId);
}
