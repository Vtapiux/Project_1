package com.revature.project1.service;

import com.revature.project1.Entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<Loan> findAllLoan();
    Loan createLoan(Loan loan);
    Optional<Loan> updateLoan(Long id, Loan loan);
}
