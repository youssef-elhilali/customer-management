package com.customer.fraud;

import com.customer.client.fraud.FraudDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/frauds")
public class FraudController {

    private final FraudService fraudService;

    public FraudController (FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping(path = "{customerId}")
    public FraudDto isFraudster (@PathVariable("customerId") Long customerId) {
        boolean isFraudster = this.fraudService.isFraudulentCustomer(customerId);
        return new FraudDto(isFraudster);
    }

}
