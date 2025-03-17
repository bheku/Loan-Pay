package org.bheku.shoni.domain.payment.mapper;

import org.bheku.shoni.domain.payment.Payment;
import org.bheku.shoni.domain.payment.repository.PaymentEntity;

public class PaymentORMTranslator {

    public static PaymentEntity fromPayment(Payment payment){
        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setAmount(payment.getAmount());
        paymentEntity.setIdentifier(payment.getIdentifier());

        return paymentEntity;
    }
}
