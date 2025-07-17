package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(Long groupId) {
        return List.of();
    }
}
