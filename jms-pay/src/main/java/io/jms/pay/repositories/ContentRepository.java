package io.jms.pay.repositories;

import io.jms.pay.models.payload.Item;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ContentRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_CONTENTS = ""
        + "INSERT INTO contents (goods_id, count, pay_id) "
        + "VALUES (?, ?, ?)";

    public void saveAll(final Long payId, final List<Item> items) {
        jdbcTemplate.batchUpdate(
            INSERT_CONTENTS,
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(final PreparedStatement ps, final int i) throws SQLException {
                    ps.setLong(1, items.get(i).getGoodsId());
                    ps.setInt(2, items.get(i).getCount());
                    ps.setLong(3, payId);
                }

                @Override
                public int getBatchSize() {
                    return items.size();
                }
            }
        );
    }
}