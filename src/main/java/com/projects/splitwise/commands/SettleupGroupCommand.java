package com.projects.splitwise.commands;

import com.projects.splitwise.Dtos.ResponseStatus;
import com.projects.splitwise.Dtos.SettleUpGroupRequestDto;
import com.projects.splitwise.Dtos.SettleUpGroupResponseDto;
import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.Repositories.UserRepository;
import com.projects.splitwise.Services.SettleUpGroupService;
import com.projects.splitwise.controllers.SettleUpController;
import com.projects.splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Long.parseLong;

@Component
public class SettleupGroupCommand implements Command{

    private final SettleUpController settleUpController;
    private final SettleUpGroupRequestDto settleUpGroupRequestDto;
    private SettleUpGroupResponseDto settleUpGroupResponseDto;
    @Autowired
    public SettleupGroupCommand(SettleUpGroupRequestDto settleUpGroupRequestDto, SettleUpGroupResponseDto settleUpGroupResponseDto, SettleUpController settleUpController, UserRepository userRepository,SettleUpGroupService settleUpGroupService){
        this.settleUpGroupRequestDto = settleUpGroupRequestDto;
        this.settleUpGroupResponseDto = settleUpGroupResponseDto;
        this.settleUpController = settleUpController;

    }


    @Override
    public Boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return (words.size()==2 && words.get(0).equalsIgnoreCase("settleUpGroup"));
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId = parseLong(words.get(1));

        settleUpGroupRequestDto.setGroupId(groupId);
//        System.out.println("created groupId");
        settleUpGroupResponseDto = settleUpController.settleUpGroup(settleUpGroupRequestDto);
        if(settleUpGroupResponseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("Group transactions are settled successfully");
            System.out.println("The transactions are:");
            for(Transaction transaction:settleUpGroupResponseDto.getTransactions()){
                User settleByUser = transaction.getSettleBy();
                User settleForUser = transaction.getSettledFor();
                System.out.println(settleByUser.getName()+"   paid   "+Math.abs(transaction.getAmount())+"   for   "+settleForUser.getName());

//                System.out.println(transaction.getSettleBy()+"   paid   "+transaction.getAmount()+"   for   "+transaction.getSettledFor());
            }

        }
        else{
            System.out.println(settleUpGroupResponseDto.getMessage());
        }

    }
}
