package week3.RemoteControl.commands;

import week3.RemoteControl.Command;
import week3.RemoteControl.ElectronicDevice;

public class StereoVolumeUp implements Command {

    ElectronicDevice myDevice;

    public StereoVolumeUp(ElectronicDevice myDevice) {
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
