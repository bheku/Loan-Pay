package org.bheku.shoni.domain.loan.service;

import org.bheku.shoni.domain.loan.Loan;
import org.bheku.shoni.domain.loan.mapper.LoanORMTranslator;
import org.bheku.shoni.domain.loan.repository.LoanEntity;
import org.bheku.shoni.domain.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    LoanRepository repository;

    @Autowired
    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public void create(Loan loan) {
        LoanEntity entity = LoanORMTranslator.fromLoan(loan);
        repository.save(entity);
    }

    public Loan findByIdentifier(String identifier){

        LoanEntity byIdentifier = repository.findByIdentifier(identifier);

        if(byIdentifier!=null) {
           return LoanORMTranslator.fromEntity(byIdentifier);
        }else {
            return null;
        }

    }

}
