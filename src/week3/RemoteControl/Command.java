package week3.RemoteControl;

// the command interface
public interface Command {
    
    public void execute();
    public void undo();
}