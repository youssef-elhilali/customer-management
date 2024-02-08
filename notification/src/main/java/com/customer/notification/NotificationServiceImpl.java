package com.customer.notification;

import com.customer.client.notification.NotificationDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(NotificationDto notificationDto) {
        Notification notification = Notification.builder()
                .customerId(notificationDto.customerId())
                .customerEmail(notificationDto.customerEmail())
                .sender("Youssef")
                .sendDate(LocalDateTime.now())
                .message(notificationDto.message())
                .build();
        this.notificationRepository.save(notification);
    }
}
