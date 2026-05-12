package org.example.springproject.patterns.command.concreteCommands;

import org.example.springproject.patterns.command.Command;
import org.example.springproject.patterns.command.Computer;

public class TurnOff implements Command {
    private Computer computer;

    public TurnOff(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.turnOff();
    }

    @Override
    public void undo() {
        computer.turnOn();
    }
}
