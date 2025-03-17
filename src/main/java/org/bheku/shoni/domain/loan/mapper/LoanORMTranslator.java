package org.bheku.shoni.domain.loan.mapper;

import org.bheku.shoni.domain.loan.Loan;
import org.bheku.shoni.domain.loan.repository.LoanEntity;

public class LoanORMTranslator {

    public static LoanEntity fromLoan(Loan loan){

        LoanEntity mappedEntity = new LoanEntity();

        mappedEntity.setAmount(loan.getAmount());
        mappedEntity.setIdentifier(loan.getIdentifier());
        mappedEntity.setTerm(loan.getTerm());

        return mappedEntity;
    }

    public static Loan fromEntity(LoanEntity entity){

        Loan mappedLoan = new Loan();

        mappedLoan.setAmount(entity.getAmount());
        mappedLoan.setIdentifier(entity.getIdentifier());
        mappedLoan.setTerm(entity.getTerm());

        return mappedLoan;
    }
}
