package org.bheku.shoni.domain.payment.service;

import org.bheku.shoni.domain.loan.repository.LoanEntity;
import org.bheku.shoni.domain.loan.repository.LoanRepository;
import org.bheku.shoni.domain.payment.Payment;
import org.bheku.shoni.domain.payment.mapper.PaymentORMTranslator;
import org.bheku.shoni.domain.payment.repository.PaymentEntity;
import org.bheku.shoni.domain.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    LoanRepository loanRepository;
    PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(LoanRepository loanRepository, PaymentRepository paymentRepository) {

        this.loanRepository = loanRepository;
        this.paymentRepository = paymentRepository;
    }

    public PaymentEntity pay(Payment payment){

        PaymentEntity paymentEntity = PaymentORMTranslator.fromPayment(payment);
        LoanEntity associatedLoan = loanRepository.findByIdentifier(payment.getLoanIdentifier());
        Double amount = associatedLoan.getAmount();
        double newAmount  = amount - payment.getAmount();

        if(newAmount > 0){
            associatedLoan.setAmount(newAmount);
        }else{
            associatedLoan.setAmount(0d);
        }

        paymentEntity.setLoanEntity(associatedLoan);

        return paymentRepository.save(paymentEntity);

    }


}
