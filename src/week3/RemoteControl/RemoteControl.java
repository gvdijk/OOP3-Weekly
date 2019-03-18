package week3.RemoteControl;

import week3.RemoteControl.commands.emptyCommand;
import java.util.Stack;

public class RemoteControl {

    private Stack<DeviceButton> commandHistory = new Stack<>();
    private DeviceButton[] buttons;
    private Command lastCommand;

    public RemoteControl() {
        buttons = new DeviceButton[4];
        DeviceButton emptyButton = new DeviceButton(new emptyCommand(), "Empty Button");
        for(int i=0;i<buttons.length;i++){
            buttons[i] = emptyButton;
        }
        lastCommand = new emptyCommand();
    }

    public void setButton(int i, DeviceButton button){
        buttons[i] = button;
    }

    public void pressButton(int i){
        System.out.println(buttons[i].getText() + " was pressed");
        buttons[i].execute();
        lastCommand = buttons[i].getCommand();
        commandHistory.push(buttons[i]);
    }

    public void pressUndo(){
        System.out.println("Undo Button was pressed");
        lastCommand.undo();
    }

    public void printHistory(){
        System.out.println("History of buttons pressed:");
        for(DeviceButton button:commandHistory){
            System.out.println(button.getText());
        }
    }
}
