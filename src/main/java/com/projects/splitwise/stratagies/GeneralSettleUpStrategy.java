package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy,Comparator<GeneralSettleUpStrategy.Pair> {
    private final Transaction transaction = new Transaction();
    @Override
    public List<Transaction> settleUp(Map<User,Integer> balanceMap) {
        List<Pair> pairs = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        int balance = 0;
        for(Map.Entry<User,Integer> payment:balanceMap.entrySet()){
            pairs.add(new Pair(payment.getKey(),payment.getValue()));
        }
        Collections.sort(pairs, this);
        Pair firstPair = pairs.get(0);
        transaction.setSettleBy(firstPair.user);
        transaction.setAmount(firstPair.amount);
        for(int i=1;i<pairs.size();i++){
            Pair p = pairs.get(i);
            if(p.amount<0){
                 transaction.setSettledFor(p.user);
                 firstPair = p;

            }
            else if (p.amount>0){
                transaction.setSettleBy(firstPair.user);
                transaction.setSettledFor(p.user);
            }
            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.amount-o2.amount;
    }
    @AllArgsConstructor
    static class Pair{
        User user;
        Integer amount;
    }
}
