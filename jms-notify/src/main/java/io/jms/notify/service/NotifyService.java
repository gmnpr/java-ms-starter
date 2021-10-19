package io.jms.notify.service;

import io.jms.notify.repositories.NotifyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotifyService {

    private static final String DEFAULT_NOTIFICATION_MESSAGE = "Thanks for the purchase :)";

    private final NotifyRepository repository;

    public void notify(final Long userId) {
        repository.save(userId, DEFAULT_NOTIFICATION_MESSAGE);
    }
}