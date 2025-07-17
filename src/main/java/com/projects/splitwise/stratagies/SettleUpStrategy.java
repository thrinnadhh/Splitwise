package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(Map<User,Integer> balanceMap);
}
