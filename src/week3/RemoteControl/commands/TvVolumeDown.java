package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

public class TvVolumeDown implements Command {

    ElectronicDevice myDevice;

    public TvVolumeDown(ElectronicDevice myDevice) {
        this.myDevice = myDevice;
    }

    @Override
    public void execute() {
        myDevice.volumeDown();
    }

    @Override
    public void undo() {
        myDevice.volumeUp();
    }
}
