package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(Long Id){
        return List.of();
    }

}
