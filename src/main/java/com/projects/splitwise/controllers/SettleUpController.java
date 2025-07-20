package com.projects.splitwise.controllers;

import com.projects.splitwise.Dtos.ResponseStatus;
import com.projects.splitwise.Dtos.SettleUpGroupRequestDto;
import com.projects.splitwise.Dtos.SettleUpGroupResponseDto;
import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.Services.SettleUpGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpGroupService settleUpGroupService;
    private SettleUpGroupRequestDto settleUpGroupRequestDto;
    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){
        SettleUpGroupResponseDto settleUpGroupResponseDto = new SettleUpGroupResponseDto();
        try{
//            Long groupId = settleUpGroupRequestDto.getGroupId();
            System.out.println("In controller");
            List<Transaction> transactions = settleUpGroupService.settleUpGroup(settleUpGroupRequestDto.getGroupId());
            settleUpGroupResponseDto.setMessage("Group transactions settled successfully");
            settleUpGroupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (Exception e) {
            settleUpGroupResponseDto.setMessage(e.getMessage());
            settleUpGroupResponseDto.setResponseStatus((ResponseStatus.FAILURE));
        }
        return settleUpGroupResponseDto;
    }
}
