package com.customer.notification;

import com.customer.client.notification.NotificationDto;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    void sendNotification(NotificationDto notificationDto);

}
