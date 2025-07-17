package com.projects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    String message;
    ResponseStatus responseStatus;
    List<Transaction> transactions;
}
