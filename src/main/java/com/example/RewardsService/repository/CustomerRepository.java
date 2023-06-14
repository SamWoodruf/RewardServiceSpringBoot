package com.example.RewardsService.repository;

import com.example.RewardsService.Exception.CustomerNotFoundException;
import com.example.RewardsService.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CustomerRepository  {
    private HashMap<Integer, Customer> customerDb;

    public Customer findById(Integer id) {
        return customerDb.get(id);
    }

    public CustomerRepository(){
        customerDb = new HashMap<>();
        customerDb.put(1, new Customer(1, "Tim"));
        customerDb.put(2, new Customer(2, "Shelly"));
        customerDb.put(3, new Customer(3, "Bert"));
        customerDb.put(4, new Customer(4, "Karen"));
    }
}
