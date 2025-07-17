package com.projects.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

//    Expense m:1 UserExpense
    @OneToMany(mappedBy="expense",fetch = FetchType.EAGER)
    private List<UserExpense> userExpenses;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User user;
}
