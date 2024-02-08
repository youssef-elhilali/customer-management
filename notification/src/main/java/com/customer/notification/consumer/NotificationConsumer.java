package com.customer.notification.consumer;

import com.customer.client.notification.NotificationDto;
import com.customer.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer (NotificationDto notificationDto) {
        log.info("Notification sent : {}", notificationDto);
        notificationService.sendNotification(notificationDto);
    }

}
