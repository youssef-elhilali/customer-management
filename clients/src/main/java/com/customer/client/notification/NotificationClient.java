package com.customer.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/api/notifications")
    void send(NotificationDto notificationDto);

}
