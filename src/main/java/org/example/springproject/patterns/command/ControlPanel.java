package org.example.springproject.patterns.command;

import java.util.HashMap;
import java.util.Map;

public class ControlPanel {  //INVOKER Вызывающий
    private Command lastExecutedCommand;
    private final Map<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no behavioral.command registered for " + commandName);
        }
        command.execute();
        lastExecutedCommand = command;
    }
    public void undoLastExecutedCommand(){
        if(lastExecutedCommand==null) throw new RuntimeException("There is no executed commands");
        lastExecutedCommand.undo();
    }
}
