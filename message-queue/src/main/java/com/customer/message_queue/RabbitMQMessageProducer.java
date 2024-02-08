package com.customer.message_queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public RabbitMQMessageProducer(@Qualifier("amqpTemplate") AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(Object payload, String exchange, String routingKey) {
        log.info("Before: Sending RabbitMQ message : {} to {} with routingKey {}", payload, exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("After: Sending RabbitMQ message : {} to {} with routingKey {}", payload, exchange, routingKey);
    }

}
