package org.bheku.shoni;

import org.bheku.shoni.domain.loan.repository.LoanEntity;
import org.bheku.shoni.domain.loan.repository.LoanRepository;
import org.bheku.shoni.domain.payment.repository.PaymentEntity;
import org.bheku.shoni.domain.payment.repository.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoniApplication.class)
public class UseCasesTest {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    public void createAndFindLoan(){

        LoanEntity loan = new LoanEntity();
        loan.setIdentifier("xad");
        loan.setAmount(200d);
        loan.setTerm(12);

        loanRepository.save(loan);

        LoanEntity byIdentifier = loanRepository.findByIdentifier("xad");
        assertNotNull(byIdentifier);

    }

    @Test
    public void createAndPayLoan(){

        LoanEntity associateLoan = loanRepository.findByIdentifier("xad");

        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setAmount(20d);
        paymentEntity.setIdentifier("xadpayment");

        associateLoan.setAmount(associateLoan.getAmount() - paymentEntity.getAmount());

        paymentEntity.setLoanEntity(associateLoan);

        PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

        assertNotNull(savedPayment.getLoanEntity().getId());
        assertNotNull(savedPayment.getId());

    }

}
