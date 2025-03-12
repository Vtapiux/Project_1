package com.revature.project1.Entities;

import jakarta.persistence.*;



@Entity

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @Column(name = "amount_requested")
    private Long amountRequested;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "loan_update")
    private String lastUpdate;

    @Column(name = "status_reason")
    private String statusReason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "loan_statuses")
    private Long loanStatus;

    @Column(name = "status_reason")
    private Long managerUpdate;


    public Loan(Long id, Long amountRequested, String loanType, String lastUpdate, String statusReason, User user, Long loanStatus, Long managerUpdate) {
        this.id = id;
        this.amountRequested = amountRequested;
        this.loanType = loanType;
        this.lastUpdate = lastUpdate;
        this.statusReason = statusReason;
        this.user = user;
        this.loanStatus = loanStatus;
        this.managerUpdate = managerUpdate;
    }

    public Loan(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Long amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Long loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Long getManagerUpdate() {
        return managerUpdate;
    }

    public void setManagerUpdate(Long managerUpdate) {
        this.managerUpdate = managerUpdate;
    }
}
