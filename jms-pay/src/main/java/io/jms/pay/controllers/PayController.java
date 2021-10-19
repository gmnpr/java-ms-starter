package io.jms.pay.controllers;

import io.jms.pay.models.payload.Cart;
import io.jms.pay.services.PayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v0/public/")
public class PayController {

    private final PayService payService;

    @PostMapping("/pay")
    public void pay(@RequestBody final Cart cart) {
        payService.pay(cart);
    }
}