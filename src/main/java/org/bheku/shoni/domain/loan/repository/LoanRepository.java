package org.bheku.shoni.domain.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Integer> {
    LoanEntity findByIdentifier(String identifier);
}
