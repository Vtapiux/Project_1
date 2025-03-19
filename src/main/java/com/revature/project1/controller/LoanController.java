package com.revature.project1.controller;

import com.revature.project1.Entities.Loan;
import com.revature.project1.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        return ResponseEntity.ok(loanService.findAllLoan());
    }

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody Loan loan){
        Loan loanCreated = loanService.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails){
        return loanService.updateLoan(id, loanDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
