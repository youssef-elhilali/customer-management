package com.customer.notification;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String queueNotification;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String routingKeysInternalNotification;

    @Bean
    public TopicExchange topicExchange () {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue queueNotification () {
        return new Queue(this.queueNotification);
    }

    @Bean
    public Binding binding () {
        return BindingBuilder.bind(queueNotification())
                .to(topicExchange())
                .with(this.routingKeysInternalNotification);
    }

}
