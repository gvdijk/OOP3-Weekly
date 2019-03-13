package week3.RemoteControl;

enum DeviceType {TV, STEREO}

public class RemoteControl {

    // return a command receiver
    public static ElectronicDevice getDevice(DeviceType type){
        if (type == DeviceType.TV) return new Television();
        else if (type == DeviceType.STEREO) return new StereoReceiver();
        else return null;
    }
}