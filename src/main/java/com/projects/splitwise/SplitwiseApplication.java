package com.projects.splitwise;

import com.projects.splitwise.commands.Command;
import com.projects.splitwise.commands.CommandExecutor;
import com.projects.splitwise.commands.SettleupGroupCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication {

    @Autowired
    SettleupGroupCommand settleupGroupCommand;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
        System.out.println("*****************************************************************************************************in main************************************************************");
    }
    public void run(String... args)throws Exception{
        settleupGroupCommand.execute("settleupGroup 1");
    }

}
