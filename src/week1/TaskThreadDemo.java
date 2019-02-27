package week1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class TaskThreadDemo extends Application {
    static Label output = new Label("Output:\n");

    public void start(Stage primaryStage) {
        Pane pane = new StackPane();
        output.setWrapText(true);
        pane.getChildren().add(output);

        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mistakes");
        primaryStage.show();

        startThreads();
    }

    private void startThreads() {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

    synchronized static void addOutput(String charToPrint) {
        output.setText(output.getText() + charToPrint);
    }
}

// The task for printing a character a specified number of times
class PrintChar implements Runnable {
    private String charToPrint; // The character to print
    private int times; // The number of times to repeat

    /** Construct a task with a specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = String.valueOf(c);
        times = t;
    }

    @Override /** Override the run() method to tell the system
     * what task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            Platform.runLater( () -> TaskThreadDemo.addOutput(charToPrint) );
        }
    }
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a task for printing 1, 2, ..., n */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            String b = String.valueOf(i);
            Platform.runLater( () -> TaskThreadDemo.addOutput(b) );
        }
    }
}