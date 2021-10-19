package io.jms.notify.configuration.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class RabbitConfiguration {

    @Value("${rabbitmq.notify-queue}")
    private String notifyQueue;

    @Value("${rabbitmq.notify-exchange}")
    private String notifyExchange;

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue notifyQueue() {
        return new Queue(notifyQueue, true);
    }

    @Bean
    public DirectExchange notifyExchange() {
        return new DirectExchange(notifyExchange);
    }

    @Bean
    public Binding notifyBinding(
        final Queue notifyQueue,
        final DirectExchange notifyExchange
    ) {
        return BindingBuilder
            .bind(notifyQueue)
            .to(notifyExchange)
            .withQueueName();
    }
}