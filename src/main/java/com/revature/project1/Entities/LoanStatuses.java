package com.revature.project1.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan_Statuses")
public class LoanStatuses {
    @Id
    @GeneratedValue
    @Column(name = "loan_statuses_id", nullable = false)
    private Long id;

    @Column(name = "loan_status")
    private String loanStatus;

    public LoanStatuses(){

    }

    public LoanStatuses(Long id, String loanStatus){
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
