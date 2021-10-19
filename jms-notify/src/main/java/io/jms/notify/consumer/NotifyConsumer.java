package io.jms.notify.consumer;

import io.jms.notify.service.NotifyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
public class NotifyConsumer {

    private final NotifyService notifyService;

    @RabbitListener(queues = "${rabbitmq.notify-queue}")
    public void notify(final Long userId) {
        log.info("Received a request to send a notification, User ID: {}", userId);

        // fake notify
        notifyService.notify(userId);
    }
}