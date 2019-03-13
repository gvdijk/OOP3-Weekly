package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

// a concrete command
public class TurnTVOff implements Command {

    ElectronicDevice myDevice;
    
    public TurnTVOff(ElectronicDevice device){
        
        myDevice = device;
    }
    
    public void execute() {
        
        myDevice.off();
    }

    @Override
    public void undo() {
        myDevice.on();
    }

}