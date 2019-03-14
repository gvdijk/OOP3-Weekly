package week3.RemoteControl.commands;

import week3.RemoteControl.Command;

public class emptyCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
