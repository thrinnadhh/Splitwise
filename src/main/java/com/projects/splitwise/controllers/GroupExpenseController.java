package com.projects.splitwise.controllers;

import com.projects.splitwise.Services.GroupExpenseService;
import com.projects.splitwise.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/groups")
public class GroupExpenseController {
    @Autowired
    private GroupExpenseService groupExpenseService;
    @GetMapping("/{groupId}/expense")
    public List<Expense> GetGroupExpenseById(@PathVariable Long groupId){
        return groupExpenseService.getGroupExpensesByGroupId(groupId);
    }
}
