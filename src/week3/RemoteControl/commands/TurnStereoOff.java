package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

public class TurnStereoOff implements Command {

    ElectronicDevice myDevice;

    public TurnStereoOff(ElectronicDevice myDevice) {
        this.myDevice = myDevice;
    }

    @Override
    public void execute() {
        myDevice.off();
    }

    @Override
    public void undo() {
        myDevice.on();
    }

}
