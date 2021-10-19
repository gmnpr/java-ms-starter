package io.jms.goods.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Page<T> {

    private final List<T> elements;
    private final Long total;
}