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
@Table(name = "loan_types")
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_type_id", nullable = false)
    private Long id;

    @Column (name = "loan_type")
    private String loanType;

    @OneToMany(mappedBy = "loanType", cascade = CascadeType.ALL)
    private List<Loan> loanTypes = new ArrayList<>();

    public LoanType(){

    }

    // public LoanType(Long id, String loanType){
    //     this.id = id;
    //     this.loanType = loanType;
    // }

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
