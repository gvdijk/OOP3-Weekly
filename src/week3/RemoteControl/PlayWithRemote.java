package week3.RemoteControl;

import week3.RemoteControl.commands.*;

// the client
public class PlayWithRemote{
    
    public static void main(String[] args){
        
        // create command receiver for tv
        ElectronicDevice tvDevice = new Television();
        // create command receiver for stereo
        ElectronicDevice stereoDevice = new StereoReceiver();
        
        // create all concrete commands for the tv, register the receiver
        TurnTVOn tvOnCommand = new TurnTVOn(tvDevice);
        TurnTVOff tvOffCommand = new TurnTVOff(tvDevice);
        TvVolumeUp tvVolumeUpCommand = new TvVolumeUp(tvDevice);
        TvVolumeDown tvVolumeDownCommand = new TvVolumeDown(tvDevice);

        // create all concrete commands for the stereo, register the receiver
        TurnStereoOn stereoOnCommand = new TurnStereoOn(stereoDevice);
        TurnStereoOff stereoOffCommand = new TurnStereoOff(stereoDevice);
        StereoVolumeUp stereoVolumeUpCommand = new StereoVolumeUp(stereoDevice);
        StereoVolumeDown stereoVolumeDownCommand = new StereoVolumeDown(stereoDevice);
    }
}