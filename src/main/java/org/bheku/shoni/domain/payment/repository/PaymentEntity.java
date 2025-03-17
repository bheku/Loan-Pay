package org.bheku.shoni.domain.payment.repository;

import jakarta.persistence.*;
import org.bheku.shoni.domain.loan.repository.LoanEntity;

@Entity
@Table(name = "loan_payment")
public class PaymentEntity {

    @Id
    @GeneratedValue
    Integer id;

    private String identifier;
    @ManyToOne
    private LoanEntity loanEntity;
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LoanEntity getLoanEntity() {
        return loanEntity;
    }

    public void setLoanEntity(LoanEntity loanEntity) {
        this.loanEntity = loanEntity;
    }
}
