package io.jms.pay.services;

import io.jms.pay.models.payload.Cart;
import io.jms.pay.produsers.NotifyProducer;
import io.jms.pay.repositories.ContentRepository;
import io.jms.pay.repositories.PayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayService {

    private final PayRepository payRepository;
    private final NotifyProducer notifyProducer;
    private final ContentRepository contentRepository;

    public void pay(final Cart cart) {
        final Long payId = payRepository.save(cart.getUserId());
        contentRepository.saveAll(payId, cart.getItems());
        notifyProducer.notify(cart.getUserId());
    }
}