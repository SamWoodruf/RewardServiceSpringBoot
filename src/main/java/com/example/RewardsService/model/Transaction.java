package com.example.RewardsService.model;

import java.util.Date;

public class Transaction {

    private Integer transactionId;
    private Integer customerId;
    private Date transactionDate;
    private double transactionAmount;

    public Transaction() {
    }

    public Transaction(Integer transactionId, Integer customerId, Date transactionDate, double transactionAmount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}
