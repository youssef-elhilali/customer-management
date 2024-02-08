package com.customer.client.notification;

import lombok.Builder;

@Builder
public record NotificationDto(Long customerId, String customerEmail, String message) {
}
