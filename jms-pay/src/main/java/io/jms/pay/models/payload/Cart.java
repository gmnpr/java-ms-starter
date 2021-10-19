package io.jms.pay.models.payload;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cart {

    private final Long userId;
    private final List<Item> items;
}