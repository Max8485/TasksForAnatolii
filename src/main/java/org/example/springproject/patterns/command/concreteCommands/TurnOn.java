package org.example.springproject.patterns.command.concreteCommands;

import org.example.springproject.patterns.command.Command;
import org.example.springproject.patterns.command.Computer;

public class TurnOn implements Command {
    private Computer computer;

    public TurnOn(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.turnOn();
    }

    @Override
    public void undo() {
        computer.turnOff();
    }
}
