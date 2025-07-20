package com.projects.splitwise.commands;

public interface Command {
    public Boolean matches(String input);
    public void execute(String input);
}
