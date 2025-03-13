package com.revature.project1.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan_Type")
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_type_id", nullable = false)
    private Long id;

    @Column(name = "loan_type")
    @OneToMany(mappedBy = "loan_type_id", cascade = CascadeType.ALL)
    private List<Loan> loanType = new ArrayList<>();


    @OneToMany
    private List<Loan> loans = new ArrayList<>();

    public LoanType(){

    }

    // public LoanType(Long id, String loanType){
    //     this.id = id;
    //     this.loanType = loanType;
    // }

    public Long getId() {
        return id;
    }
    public List<Loan> getLoanType() {
        return loanType;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLoanType(List<Loan> loanType) {
        this.loanType = loanType;
    }
}
