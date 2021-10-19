package io.jms.notify.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class NotifyRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_NOTIFICATION = ""
        + "INSERT INTO notifications "
        + "(user_id, message, send_date) "
        + "VALUES (?, ?, NOW())";

    public void save(final Long userId, final String message) {
        jdbcTemplate.update(
            INSERT_NOTIFICATION,
            userId,
            message
        );
    }
}