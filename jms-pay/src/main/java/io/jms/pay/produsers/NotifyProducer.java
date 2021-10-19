package io.jms.pay.produsers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class NotifyProducer {

    @Value("${rabbitmq.routing-key}")
    private String notifyQueue;

    @Value("${rabbitmq.notify-exchange}")
    private String notifyExchange;

    private final RabbitTemplate template;

    public void notify(final Long userId) {
        template.convertAndSend(notifyExchange, notifyQueue,  userId);
        log.info("Notification sent, User ID: {}", userId);
    }
}