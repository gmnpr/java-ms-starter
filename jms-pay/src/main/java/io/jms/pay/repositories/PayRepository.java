package io.jms.pay.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PayRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_PAY = ""
        + "INSERT INTO pays "
        + "(user_id) "
        + "VALUES (?) "
        + "RETURNING id";

    public Long save(final Long userId) {
        return jdbcTemplate.queryForObject(
            INSERT_PAY,
            Long.class,
            userId
        );
    }
}
