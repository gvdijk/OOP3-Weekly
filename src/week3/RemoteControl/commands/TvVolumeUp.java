package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

public class TvVolumeUp implements Command {

    ElectronicDevice myDevice;

    public TvVolumeUp(ElectronicDevice myDevice) {
        this.myDevice = myDevice;
    }

    @Override
    public void execute() {
        myDevice.volumeUp();
    }

    @Override
    public void undo() {
        myDevice.volumeDown();
    }
}
