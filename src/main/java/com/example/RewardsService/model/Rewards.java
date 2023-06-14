package com.example.RewardsService.model;

import java.util.HashMap;
import java.util.Map;

public class Rewards {
    private Map<String, Integer> rewardsMonthMap = new HashMap<>();
    private int customerId;
    private int rewardsTotal;

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRewardsTotal() {
        return rewardsTotal;
    }

    public void setRewardsTotal(int rewardsTotal) {
        this.rewardsTotal = rewardsTotal;
    }

    public void addRewards(String month, Integer points){
        rewardsMonthMap.put(month, points);
    }

    public void setRewardsMonthMap(Map<String, Integer> rewardsMonthMap) {
        this.rewardsMonthMap = rewardsMonthMap;
    }

    public Map<String, Integer> getRewardsMonthMap(){
        return this.rewardsMonthMap;
    }
}
