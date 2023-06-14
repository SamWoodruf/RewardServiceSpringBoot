package com.example.RewardsService.model;

import java.util.HashMap;

public class Customer {
    Integer customerId;
    String custerName;

    public Customer() {
    }

    public Customer(Integer customerId, String custerName) {
        this.customerId = customerId;
        this.custerName = custerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

}
