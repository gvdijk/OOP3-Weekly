package week3.RemoteControl;

import week3.RemoteControl.commands.*;

// the client
public class PlayWithRemote{
    
    public static void main(String[] args){
        
        // create command receiver for tv
        ElectronicDevice tvDevice = new Television();
        // create command receiver for stereo
        ElectronicDevice stereoDevice = new StereoReceiver();
        
        // create all buttons for the tv
        DeviceButton tvOnButton = new DeviceButton(new TurnTVOn(tvDevice), "TV ON");
        TurnTVOff tvOffCommand = new TurnTVOff(tvDevice);
        TvVolumeUp tvVolumeUpCommand = new TvVolumeUp(tvDevice);
        TvVolumeDown tvVolumeDownCommand = new TvVolumeDown(tvDevice);

        // create all buttons for the stereo
        TurnStereoOn stereoOnCommand = new TurnStereoOn(stereoDevice);
        TurnStereoOff stereoOffCommand = new TurnStereoOff(stereoDevice);
        StereoVolumeUp stereoVolumeUpCommand = new StereoVolumeUp(stereoDevice);
        StereoVolumeDown stereoVolumeDownCommand = new StereoVolumeDown(stereoDevice);
    }
}