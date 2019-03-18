package week3.RemoteControl;

import week3.RemoteControl.commands.*;

// the client
public class PlayWithRemote{
    
    public static void main(String[] args){
        
        // create command receiver for tv
        ElectronicDevice tvDevice = new Television();
        // create command receiver for stereo
        ElectronicDevice stereoDevice = new StereoReceiver();
        // create remote control
        RemoteControl remote = new RemoteControl();
        
        // create all buttons for the tv
        DeviceButton tvOnButton = new DeviceButton(new TurnTVOn(tvDevice), "TV ON");
        DeviceButton tvOffButton = new DeviceButton(new TurnTVOff(tvDevice), "TV OFF");
        DeviceButton tvVolumeUpButton = new DeviceButton(new TvVolumeUp(tvDevice), "TV Volume Up");
        DeviceButton tvVolumeDownButton = new DeviceButton(new TvVolumeDown(tvDevice), "TV Volume Down");

        // create all buttons for the stereo
        DeviceButton stereoOnButton = new DeviceButton(new TurnStereoOn(stereoDevice), "Stereo ON");
        DeviceButton stereoOffButton = new DeviceButton(new TurnStereoOff(stereoDevice), "Stereo OFF");
        DeviceButton stereoVolumeUpButton = new DeviceButton(new StereoVolumeUp(stereoDevice), "Stereo Volume Up");
        DeviceButton stereoVolumeDownButton = new DeviceButton(new StereoVolumeDown(stereoDevice), "Stereo Volume Down");

        //Register some buttons on the remote
        remote.setButton(0, tvOnButton);
        remote.setButton(1, tvOffButton);
        remote.setButton(2, tvVolumeUpButton);
        remote.setButton(3, tvVolumeDownButton);

        //Press the buttons
        remote.pressButton(0);
        for (int i=0;i < 3;i++) remote.pressButton(2);
        remote.pressUndo();
        remote.pressButton(1);
        remote.printHistory();
    }
}