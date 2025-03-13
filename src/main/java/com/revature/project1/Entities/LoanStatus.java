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

    @OneToMany(mappedBy = "loan_status", cascade = CascadeType.ALL)
    private List<Loan> loanStatus = new ArrayList<>();

    public LoanStatus(){

    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public List<Loan> getLoanStatus() {return loanStatus;}

    public void setLoanStatus(List<Loan> loanStatus) {this.loanStatus = loanStatus;}
}
