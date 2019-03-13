package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

public class TurnStereoOn implements Command {

    ElectronicDevice myDevice;

    public TurnStereoOn(ElectronicDevice myDevice) {
        this.myDevice = myDevice;
    }

    @Override
    public void execute() {
        myDevice.on();
    }

    @Override
    public void undo() {
        myDevice.off();
    }
}
