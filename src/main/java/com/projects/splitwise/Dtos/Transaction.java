package com.projects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class Transaction {
    Long hasToPayId;
    Long getsPaidId;
    Integer amount;
}
