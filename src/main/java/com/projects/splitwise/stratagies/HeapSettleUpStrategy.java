package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    private final Transaction transaction = new Transaction();
    @Override
    public List<Transaction> settleUp(Map<User,Integer> balanceMap){
        PriorityQueue<Pair> paidByQueue = new PriorityQueue<>((a,b)->b.amount-a.amount);
        PriorityQueue<Pair> paidForQueue = new PriorityQueue<>();
        List<Transaction> transactions = new ArrayList<>();
        for(Map.Entry<User,Integer> payment:balanceMap.entrySet()){
            if(payment.getValue()>0){
                paidByQueue.add(new Pair(payment.getKey(),payment.getValue()));
            }
            else{
                paidForQueue.add(new Pair(payment.getKey(),payment.getValue()));
            }
        }
        while(!paidByQueue.isEmpty() && !paidForQueue.isEmpty()){
            Pair paidBy = paidByQueue.poll();
            Pair paidFor = paidForQueue.poll();

            int differenceAmount = paidBy.amount + paidFor.amount;
            transaction.setSettleBy(paidFor.user);
            transaction.setSettledFor(paidBy.user);
            transaction.setAmount(paidBy.amount);

            if(differenceAmount>0){
                paidByQueue.add(new Pair(paidBy.user,differenceAmount));
            }
            else if(differenceAmount<0){
                paidForQueue.add(new Pair(paidFor.user,differenceAmount));
            }
            transactions.add(transaction);

        }
        return transactions;
    }
    @AllArgsConstructor
    static class Pair{
        User user;
        Integer amount;

    }
}

