package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(Long groupId);
}
