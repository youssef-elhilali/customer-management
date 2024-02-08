package com.customer.app;

import lombok.Builder;

@Builder
public record CustomerDto (
        String firstName,
        String lastName,
        String email
) {



}
