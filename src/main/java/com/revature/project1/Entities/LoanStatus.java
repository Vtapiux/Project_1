package com.revature.project1.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Loan_Status")
public class LoanStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_status_id", nullable = false)
    private Long id;

    @Column(name = "loan_status")
    private String loanStatus;

    @OneToMany(mappedBy = "loanStatus", cascade = CascadeType.ALL)
    private List<Loan> loanByStatus = new ArrayList<>();

    public LoanStatus(){

    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getLoanStatus() {return loanStatus;}

    public void setLoanStatus(String loanStatus) {this.loanStatus = loanStatus;}

    public List<Loan> getLoanByStatus() {
        return loanByStatus;
    }

    public void setLoanByStatus(List<Loan> loanByStatus) {
        this.loanByStatus = loanByStatus;
    }
}
