package io.jms.goods.utils;

public class SqlPaginationUtils {

    private SqlPaginationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final Integer DEFAULT_PAGE_SIZE = 20;
    private static final String PAGING_TEMPLATE = "%s LIMIT %s OFFSET %s";

    public static String getSqlWithPaging(final String sql, final Integer page) {
        final Integer offset = page * DEFAULT_PAGE_SIZE;
        return String.format(PAGING_TEMPLATE, sql, DEFAULT_PAGE_SIZE, offset);
    }
}