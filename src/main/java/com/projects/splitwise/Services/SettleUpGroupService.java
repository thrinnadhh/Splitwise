package com.projects.splitwise.Services;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.Repositories.GroupRepository;
import com.projects.splitwise.models.*;
import com.projects.splitwise.stratagies.HeapSettleUpStrategy;
import com.projects.splitwise.stratagies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SettleUpGroupService {
    private GroupRepository groupRepository;
    private HeapSettleUpStrategy heapSettleUpStrategy;
    @Autowired
    public SettleUpGroupService(GroupRepository groupRepository,HeapSettleUpStrategy heapSettleUpStrategy){
        this.groupRepository = groupRepository;
        this.heapSettleUpStrategy = heapSettleUpStrategy;
    }
   public List<Transaction> settleUpGroup(Long groupId){
//        Group Validation
       Optional<Group> optionalGroup = groupRepository.findById(groupId);

       if(optionalGroup.isEmpty()){
           throw new IllegalArgumentException("Group with id "+groupId+" not found");
       }
       List< Expense> expenses = optionalGroup.get().getExpenses();
       for(int i=0;i<expenses.size();i++){

           System.out.println(expenses.get(i));
       }

//       Making the balanceMap;
       Map<User,Integer> balanceMap = new HashMap<>();
       for(Expense expense:expenses){
           for(UserExpense userExpense:expense.getUserExpenses()){
               User user = userExpense.getUser();
               balanceMap.putIfAbsent(user,0);
               if(userExpense.getUserExpenseType().equals(UserExpenseType.PAIDBY)){
                   balanceMap.put(user,balanceMap.get(user)+userExpense.getAmount());
               }
               else if(userExpense.getUserExpenseType().equals(UserExpenseType.PAIDFOR)){
                   balanceMap.put(user,balanceMap.get(user) - userExpense.getAmount());
               }
           }
       }
       System.out.println("balance map got created and getting passed to heap");
       return heapSettleUpStrategy.settleUp(balanceMap);
   }
}
