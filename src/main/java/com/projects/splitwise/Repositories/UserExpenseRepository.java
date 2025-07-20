package com.projects.splitwise.Repositories;

import com.projects.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
}
