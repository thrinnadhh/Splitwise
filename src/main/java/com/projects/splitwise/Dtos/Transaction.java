package com.projects.splitwise.Dtos;

import com.projects.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    User settleBy;
    User settledFor;
    Integer amount;
}
