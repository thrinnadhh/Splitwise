package com.projects.splitwise.Repositories;

import com.projects.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
