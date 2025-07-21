package com.projects.splitwise;

import com.projects.splitwise.commands.Command;
import com.projects.splitwise.commands.CommandExecutor;
import com.projects.splitwise.commands.SettleupGroupCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    private SettleupGroupCommand settleUpGroupCommand;
    private DataGenerator dataGenerator;

    @Autowired
    public SplitwiseApplication(SettleupGroupCommand settleupGroupCommand,DataGenerator dataGenerator){
        this.settleUpGroupCommand = settleupGroupCommand;
        this.dataGenerator = dataGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
//        System.out.println("***************************************************************************************************** in run ************************************************************");

//        System.out.println("Data generation object created");
//        dataGenerator.generateData();
//        System.out.println("Data Generation is successful");
        settleUpGroupCommand.execute("settleupGroup 1");
    }

}
