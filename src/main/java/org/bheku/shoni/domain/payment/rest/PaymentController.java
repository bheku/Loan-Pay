package org.bheku.shoni.domain.payment.rest;

import org.bheku.shoni.domain.payment.Payment;
import org.bheku.shoni.domain.payment.repository.PaymentEntity;
import org.bheku.shoni.domain.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Payment payment){

        PaymentEntity paid = paymentService.pay(payment);

    }
}
