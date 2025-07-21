package com.projects.splitwise.stratagies;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.Repositories.UserRepository;
import com.projects.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    private Transaction transaction;
    @Override
    public List<Transaction> settleUp(Map<User,Integer> balanceMap){
//        System.out.println("In service settleUpHeap");
        PriorityQueue<Pair> paidByQueue = new PriorityQueue<>((a,b)->b.amount-a.amount);
        PriorityQueue<Pair> paidForQueue = new PriorityQueue<>((a, b) -> a.amount - b.amount);
        List<Transaction> transactions = new ArrayList<>();
        for(Map.Entry<User,Integer> payment:balanceMap.entrySet()){
//            User user = payment.getKey();
//            System.out.println(user.getName()+" value "+payment.getValue());
            if(payment.getValue()>0){
                paidByQueue.add(new Pair(payment.getKey(),payment.getValue()));
            }
            else{
                paidForQueue.add(new Pair(payment.getKey(),payment.getValue()));
            }
        }
        while(!paidByQueue.isEmpty() && !paidForQueue.isEmpty()){
            transaction = new Transaction();
//            System.out.println("A new Transaction got created "+transaction);
            Pair paidBy = paidByQueue.poll();
            Pair paidFor = paidForQueue.poll();
            User user1 = paidBy.user;
            User user2 = paidFor.user;

            int differenceAmount = paidBy.amount + paidFor.amount;
            transaction.setSettleBy(paidFor.user);
            transaction.setSettledFor(paidBy.user);
            transaction.setAmount(paidFor.amount);
//            System.out.println("the difference amount is "+differenceAmount);

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
    class Pair{
        User user;
        Integer amount;

    }
}

