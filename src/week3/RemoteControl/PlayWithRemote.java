package week3.RemoteControl;

import week3.RemoteControl.commands.*;

// the client
public class PlayWithRemote{
    
    public static void main(String[] args){
        
        // create command receiver for tv
        ElectronicDevice tvDevice = RemoteControl.getDevice(DeviceType.TV);
        // create command receiver for stereo
        ElectronicDevice stereoDevice = RemoteControl.getDevice(DeviceType.STEREO);
        
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

        // create invokers
        DeviceButton b = new DeviceButton();
        
        // invoke commands
        b.execute(tvOnCommand);
        for(int i=0;i<3;i++){
            b.execute(tvVolumeUpCommand);
        }
        b.execute(tvVolumeDownCommand);
        b.undo(tvVolumeDownCommand);

        b.execute(stereoOnCommand);
        b.execute(stereoVolumeUpCommand);
        b.undo(stereoVolumeUpCommand);
        b.execute(stereoOffCommand);

        b.printHistory();
    }
}