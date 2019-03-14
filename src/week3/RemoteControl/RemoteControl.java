package week3.RemoteControl;

import week3.RemoteControl.commands.emptyCommand;
import java.util.Stack;

public class RemoteControl {

    private Stack<DeviceButton> commandHistory = new Stack<>();
    private DeviceButton[] buttons;
    private Command undoButton;

    public RemoteControl() {
        buttons = new DeviceButton[4];
        DeviceButton emptyButton = new DeviceButton(new emptyCommand(), "Empty Button");
        for(int i=0;i<buttons.length;i++){
            buttons[i] = emptyButton;
        }
        undoButton = new emptyCommand();
    }

    public void setButton(int i, DeviceButton button){
        buttons[i] = button;
    }

    public void pressButton(int i){
        buttons[i].execute();
        commandHistory.push(buttons[i]);
    }

    public void printHistory(){
        System.out.println("History of buttons pressed:");
        for(DeviceButton button:commandHistory){
            System.out.println(button);
        }
    }
}
