package io.jms.goods.repositories;

import io.jms.goods.mappers.GoodsMapper;
import io.jms.goods.models.Goods;
import io.jms.goods.models.Page;
import io.jms.goods.utils.SqlPaginationUtils;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class GoodsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final GoodsMapper goodsMapper;


    private static final String FIND_ALL_GOODS = ""
        + "SELECT *"
        + "FROM goods";

    private static final String COUNT_GOODS = ""
        + "SELECT COUNT(*) "
        + "FROM goods";

    public Page<Goods> findAll(final Integer page) {
        final List<Goods> goods = jdbcTemplate.query(
            SqlPaginationUtils.getSqlWithPaging(FIND_ALL_GOODS, page),
            goodsMapper
        );
        final Long count = jdbcTemplate.queryForObject(
            COUNT_GOODS,
            Long.class
        );
        return new Page<>(goods, count);
    }
}