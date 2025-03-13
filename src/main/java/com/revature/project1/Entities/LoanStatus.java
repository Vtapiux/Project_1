package com.revature.project1.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Loan_status")
public class LoanStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_status_id", nullable = false)
    private Long id;

    @Column(name = "loan_status")
    @OneToMany(mappedBy = "loan_status_id", cascade = CascadeType.ALL)
    private List<Loan> loanStatus = new ArrayList<>();

    public LoanStatus() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public List<Loan> getLoanStatus() {return loanStatus;}

    public void setLoanStatus(List<Loan> loanStatus) {this.loanStatus = loanStatus;}
}
