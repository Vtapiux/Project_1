package com.revature.project1.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan_Type")
public class LoanType {
    @Id
    @GeneratedValue
    @Column(name = "loan_type_id", nullable = false)
    private Long id;

    @Column(name = "loan_type")
    private String loanType;

    public LoanType(){

    }

    public LoanType(Long id, String loanType){
        this.id = id;
        this.loanType = loanType;
    }

    public Long getId() {
        return id;
    }
    public String getLoanType() {
        return loanType;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
}
