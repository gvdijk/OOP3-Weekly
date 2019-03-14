package week3.RemoteControl;

public class DeviceButton {

    private Command command;
    private String text;

    public DeviceButton(Command command, String text) {
        this.command = command;
        this.text = text;
    }

    public void execute(){
        
        System.out.println("Device button is pressed !");
        command.execute();
    }
}
