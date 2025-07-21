package com.projects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class SettleUpGroupResponseDto {
    String message;
    ResponseStatus responseStatus;
    List<Transaction> transactions;
}
