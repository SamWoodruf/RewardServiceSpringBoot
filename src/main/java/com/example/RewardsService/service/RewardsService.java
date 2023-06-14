package com.example.RewardsService.service;

import com.example.RewardsService.Exception.CustomerNotFoundException;
import com.example.RewardsService.model.Customer;
import com.example.RewardsService.model.Rewards;
import com.example.RewardsService.model.Transaction;
import com.example.RewardsService.repository.CustomerRepository;
import com.example.RewardsService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardsService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;
    public Rewards getCustomerRewardsByMonth(Integer customerId){
        Rewards rewards = new Rewards();

        Map<String, List<Transaction>> customerTransactionsByMonth = transactionRepository.getTransactionByCustomerId(customerId)
                .stream().collect(Collectors.groupingBy(e -> convertDateToMonthString(e.getTransactionDate())));

        Map<String, Integer> rewardsTotalPerMonth = customerTransactionsByMonth.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e-> calculateRewardsForTransactionList(e.getValue())));

        rewards.setCustomerId(customerId);
        rewards.setRewardsMonthMap(rewardsTotalPerMonth);
        rewards.setRewardsTotal(sumRewards(rewardsTotalPerMonth));
        return rewards;
    }


    public Customer getCustomerIfExists(Integer id){
        return Optional.ofNullable(customerRepository.findById(id)).orElseThrow(CustomerNotFoundException::new);
    }

    public int sumRewards(Map<String, Integer> rewardsTotalPerMonth){
        return rewardsTotalPerMonth.entrySet().stream().mapToInt(f -> f.getValue()).sum();
    }

    public int calculateRewardsForTransactionList(List<Transaction> transactions){
        int rewardTotal = 0;
        for(Transaction t: transactions){
            if(t.getTransactionAmount() >= 50 && t.getTransactionAmount() < 100){
                rewardTotal += t.getTransactionAmount() - 50;
            } else if(t.getTransactionAmount() > 100){
                rewardTotal += (2 * (t.getTransactionAmount() - 100) + 50);
            }
        }
        return rewardTotal;
    }

    public String convertDateToMonthString(Date date){
       return new SimpleDateFormat("MMM", Locale.ENGLISH).format(date);
    }
}
