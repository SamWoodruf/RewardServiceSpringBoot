package com.example.RewardsService.repository;

import com.example.RewardsService.model.Customer;
import com.example.RewardsService.model.Transaction;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {
    private HashMap<Integer, Transaction> transactionDb;

    public List<Transaction> getTransactionByCustomerId(Integer customerId){
        return transactionDb.entrySet().stream()
                .filter(e -> e.getValue().getCustomerId() == customerId)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public TransactionRepository(){
        transactionDb = new HashMap<>();
        transactionDb.put(1, new Transaction(1, 1, new Date("6/13/2023"), 6.78));
        transactionDb.put(2, new Transaction(2, 1, new Date("6/17/2023"), 100.78));
        transactionDb.put(3, new Transaction(3, 1, new Date("6/30/2023"), 189.36));
        transactionDb.put(4, new Transaction(4, 1, new Date("5/29/2023"), 75.78));
        transactionDb.put(5, new Transaction(5, 1, new Date("5/20/2023"), 13.90));
        transactionDb.put(6, new Transaction(6, 1, new Date("5/4/2023"), 120.99));
        transactionDb.put(7, new Transaction(7, 1, new Date("4/6/2023"), 77.70));
        transactionDb.put(8, new Transaction(8, 1, new Date("4/19/2023"), 90.78));
        transactionDb.put(9, new Transaction(9, 1, new Date("4/13/2023"), 150.78));
        transactionDb.put(10, new Transaction(10, 1, new Date("3/20/2023"), 15.78));
        transactionDb.put(11, new Transaction(11, 1, new Date("3/21/2023"), 50.78));
        transactionDb.put(12, new Transaction(12, 1, new Date("3/27/2023"), 5.78));

        transactionDb.put(14, new Transaction(14, 2, new Date("6/5/2023"), 120.00));

        transactionDb.put(15, new Transaction(15, 3, new Date("6/4/2023"), 10.99));
        transactionDb.put(16, new Transaction(16, 3, new Date("5/14/2023"), 15.99));
        transactionDb.put(17, new Transaction(17, 3, new Date("4/24/2023"), 20.99));
        transactionDb.put(18, new Transaction(18, 3, new Date("3/20/2023"), 51.99));

        transactionDb.put(19, new Transaction(19, 4, new Date("6/4/2023"), 75.99));
        transactionDb.put(20, new Transaction(20, 4, new Date("5/1/2023"), 75.99));
    }

}

