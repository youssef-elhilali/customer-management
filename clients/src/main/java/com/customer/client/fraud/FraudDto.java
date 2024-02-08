package com.customer.client.fraud;

import lombok.Builder;

@Builder
public record FraudDto(
        Boolean isFraudster
) {
}
