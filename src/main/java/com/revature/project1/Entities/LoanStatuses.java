package com.revature.project1.Entities;

<<<<<<< HEAD:src/main/java/com/revature/project1/Entities/LoanStatus.java
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
=======
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Loan_status")
public class LoanStatuses {
>>>>>>> b6ae4c5a7292fd16a3fdfdda7b27646ede74fdb8:src/main/java/com/revature/project1/Entities/LoanStatuses.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_status_id", nullable = false)
    private Long id;

    @Column(name = "loan_status")
    @OneToMany(mappedBy = "loan_status", cascade = CascadeType.ALL)
    private List<Loan> loanStatus = new ArrayList<>();

<<<<<<< HEAD:src/main/java/com/revature/project1/Entities/LoanStatus.java



    public LoanStatus(){

    }

    public LoanStatus(Long id, String loanStatus){
        this.id = id;
        this.loanStatus = loanStatus;
    }
=======
    public LoanStatuses() {

    }

    public Long getId() {return id;}
>>>>>>> b6ae4c5a7292fd16a3fdfdda7b27646ede74fdb8:src/main/java/com/revature/project1/Entities/LoanStatuses.java

    public void setId(Long id) {this.id = id;}

    public List<Loan> getLoanStatus() {return loanStatus;}

    public void setLoanStatus(List<Loan> loanStatus) {this.loanStatus = loanStatus;}
}
