package week3.RemoteControl;

import java.util.Stack;

// invoker
public class DeviceButton {

    private Stack<Command> commandHistory = new Stack<>();
    
    public void execute(Command cmd){
        
        System.out.println("Device button is pressed !");
        cmd.execute();
        commandHistory.push(cmd);
    }

    public void undo(Command cmd){
        System.out.println("Undo button is pressed !");
        cmd.undo();
        commandHistory.push(cmd);
    }

    public void printHistory(){
        System.out.println("History of buttons pressed:");
        for(Command cmd:commandHistory){
            System.out.println(cmd);
        }
    }
}