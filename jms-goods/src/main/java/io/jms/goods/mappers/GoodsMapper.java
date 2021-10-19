package io.jms.goods.mappers;

import io.jms.goods.models.Goods;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class GoodsMapper implements RowMapper<Goods> {

    private static final String FIELD_NAME_ID = "id";
    private static final String FIELD_NAME_NAME = "name";
    private static final String FIELD_NAME_PRICE = "price";

    @Override
    public Goods mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new Goods(
            rs.getLong(FIELD_NAME_ID),
            rs.getString(FIELD_NAME_NAME),
            rs.getDouble(FIELD_NAME_PRICE)
        );
    }
}