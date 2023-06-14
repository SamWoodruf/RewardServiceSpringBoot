package com.example.RewardsService.controller;

import com.example.RewardsService.Exception.CustomerNotFoundException;
import com.example.RewardsService.model.Customer;
import com.example.RewardsService.model.Rewards;
import com.example.RewardsService.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
    @Autowired
    RewardsService rewardsService;
    @GetMapping("/{customerId}")
    public Rewards getCustomerRewardsById(@PathVariable Integer customerId){
        Customer customer = rewardsService.getCustomerIfExists(customerId);
        return rewardsService.getCustomerRewardsByMonth(customer.getCustomerId());
    }

    @ExceptionHandler({ CustomerNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return("No customer with this id found");
    }
}
