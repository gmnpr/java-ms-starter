package io.jms.goods.controllers;

import io.jms.goods.models.Goods;
import io.jms.goods.models.Page;
import io.jms.goods.services.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v0/public/")
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/goods")
    public Page<Goods> findAll(@RequestParam final Integer page) {
        return goodsService.findAll(page);
    }
}