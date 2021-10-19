package io.jms.pay.models.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

    private final Long goodsId;
    private final Integer count;
}