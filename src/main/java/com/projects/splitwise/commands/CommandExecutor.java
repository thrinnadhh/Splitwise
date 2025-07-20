package com.projects.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor{

    List<Command>commands = new ArrayList<>();

    public void registerCommand(Command command){
        commands.add(command);
    }
    public void deregisterCommand(Command command){
        commands.remove(command);
    }
    public void executeCommand(String input){
        for(Command command:commands){
            if(command.matches(input)){
                command.execute(input);
            }
        }
    }
}
