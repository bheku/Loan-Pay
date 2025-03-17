package org.bheku.shoni.domain.loan.rest;

import org.bheku.shoni.domain.loan.Loan;
import org.bheku.shoni.domain.loan.rest.exception.LoanNotFoundException;
import org.bheku.shoni.domain.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {

    private final LoanService service;

    @Autowired
    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping("/loans")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLoan(@RequestBody Loan loan){
        service.create(loan);
    }

    @GetMapping("/loans/{identifier}")
    @ResponseStatus(HttpStatus.FOUND)
    public Loan findByIdentifier(@PathVariable String identifier){

        Loan byIdentifier = service.findByIdentifier(identifier);

        if(byIdentifier == null){
            throw new LoanNotFoundException("Could not find loan with id:"+identifier);
        }

        return byIdentifier;
    }

}
