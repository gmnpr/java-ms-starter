package io.jms.goods.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Goods {

    private final Long id;
    private final String name;
    private final Double price;
}