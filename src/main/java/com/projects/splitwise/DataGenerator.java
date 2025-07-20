package com.projects.splitwise;

import com.projects.splitwise.Repositories.ExpenseRepository;
import com.projects.splitwise.Repositories.GroupRepository;
import com.projects.splitwise.Repositories.UserExpenseRepository;
import com.projects.splitwise.Repositories.UserRepository;
import com.projects.splitwise.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {
    @Autowired
    public UserRepository userRepositories;
    @Autowired
    public GroupRepository groupRepositories;
    @Autowired
    public ExpenseRepository expenseRepositories;
    @Autowired
    public UserExpenseRepository UserExpenseRepositories;

    public void generateData(){
        User user1 = new User();
        user1.setName("Akash");
        user1.setPhoneNumber("123456");
        user1.setPassword("passpass");

        userRepositories.save(user1);

        User user2 = new User();
        user2.setName("Sam");
        user2.setPhoneNumber("1233456");
        user2.setPassword("passpass");

        userRepositories.save(user2);

        User user3 = new User();
        user3.setName("Rajesh");
        user3.setPhoneNumber("456789");
        user3.setPassword("passpass");

        userRepositories.save(user3);

        User user4 = new User();
        user4.setName("Amrita");
        user4.setPhoneNumber("122333444");
        user4.setPassword("passpass");

        userRepositories.save(user4);

        List<User> members = new ArrayList<>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        members.add(user4);



        //Creating a group
        Group group = new Group();
        group.setName("GoaTrip");
        group.setAdmin(user1);
        group.setMembers(members);
        List<Expense> expenses = new ArrayList<>();
        groupRepositories.save(group);

        //Creating an expense
        Expense ex1 = new Expense();
        ex1.setAmount(2000);
        ex1.setGroup(group);
        ex1.setDescription("Goa car rent");
        ex1.setExpenseType(ExpenseType.EXPENDITURE);
        expenseRepositories.save(ex1);

        //List to store all expenseUsers
        List<UserExpense> expenseUsers = new ArrayList<>();

        //Creating expense users
        UserExpense eu1 = new UserExpense();
        eu1.setAmount(2000);
        eu1.setUser(user1);
        eu1.setUserExpenseType(UserExpenseType.PAIDBY);
        eu1.setExpense(ex1);

        UserExpenseRepositories.save(eu1);

        UserExpense eu2 = new UserExpense();
        eu2.setAmount(500);
        eu2.setUser(user1);
        eu2.setUserExpenseType(UserExpenseType.PAIDFOR);
        eu2.setExpense(ex1);

        UserExpenseRepositories.save(eu2);

        UserExpense eu3 = new UserExpense();
        eu3.setAmount(500);
        eu3.setUser(user2);
        eu3.setUserExpenseType(UserExpenseType.PAIDFOR);
        eu3.setExpense(ex1);

        UserExpenseRepositories.save(eu3);

        UserExpense eu4 = new UserExpense();
        eu4.setAmount(500);
        eu4.setUser(user3);
        eu4.setUserExpenseType(UserExpenseType.PAIDFOR);
        eu4.setExpense(ex1);

        UserExpenseRepositories.save(eu4);

        UserExpense eu5 = new UserExpense();
        eu5.setAmount(500);
        eu5.setUser(user4);
        eu5.setUserExpenseType(UserExpenseType.PAIDFOR);
        eu5.setExpense(ex1);

        UserExpenseRepositories.save(eu5);

        expenseUsers.add(eu1);
        expenseUsers.add(eu2);
        expenseUsers.add(eu3);
        expenseUsers.add(eu4);
        expenseUsers.add(eu5);


        ex1.setUserExpenses(expenseUsers);

        expenseRepositories.save(ex1);

        expenses.add(ex1);

        group.setExpenses(expenses);

        groupRepositories.save(group);
        System.out.println("Data generation done");
    }

}