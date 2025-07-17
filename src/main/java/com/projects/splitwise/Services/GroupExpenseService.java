package com.projects.splitwise.Services;

import com.projects.splitwise.Repositories.ExpenseRepository;
import com.projects.splitwise.models.Expense;
import com.projects.splitwise.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupExpenseService {
    private final ExpenseRepository expenseRepository;
    @Autowired
    public GroupExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> getGroupExpensesByGroupId(Long groupId){
        Optional<Expense> optionalExpenses =  expenseRepository.findById(groupId);
        if(optionalExpenses.isEmpty()){
            throw new RuntimeException("groupExpenses not found");
        }
        else{
            return optionalExpenses.stream().toList();
        }
    }
}