package week3.RemoteControl;

public class DeviceButton {

    private Command command;
    private String text;

    public DeviceButton(Command command, String text) {
        this.command = command;
        this.text = text;
    }

    public Command getCommand(){
        return command;
    }

    public String getText(){
        return text;
    }

    public void execute(){
        command.execute();
    }
}
