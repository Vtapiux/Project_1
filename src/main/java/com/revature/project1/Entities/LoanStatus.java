package com.revature.project1.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan_Status")
public class LoanStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_status_id", nullable = false)
    private Long id;

    @Column(name = "loan_status")
    private String loanStatus;




    public LoanStatus(){

    }

    public LoanStatus(Long id, String loanStatus){
        this.id = id;
        this.loanStatus = loanStatus;
    }

    public Long getId() {
        return id;
    }
    public String getLoanStatus() {
        return loanStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
