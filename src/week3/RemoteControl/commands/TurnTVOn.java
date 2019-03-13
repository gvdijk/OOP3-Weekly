package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

// a concrete command
public class TurnTVOn implements Command {

    ElectronicDevice myDevice;
    
    public TurnTVOn(ElectronicDevice device){
        // register receiver
        myDevice = device;
    }
    
    public void execute() {

        myDevice.on();
    }

    @Override
    public void undo() {
        myDevice.off();
    }
}