package io.jms.goods.services;

import io.jms.goods.models.Goods;
import io.jms.goods.models.Page;
import io.jms.goods.repositories.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodsService {

    private final GoodsRepository repository;

    public Page<Goods> findAll(final Integer page) {
        return repository.findAll(page);
    }
}