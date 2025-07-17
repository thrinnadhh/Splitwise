package com.projects.splitwise.Repositories;

import com.projects.splitwise.models.Expense;
import com.projects.splitwise.models.Group;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Example<? extends Expense> group(Group group);
}
