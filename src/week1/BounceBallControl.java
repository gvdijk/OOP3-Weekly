package week1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBallControl extends Application {
    BallPane ballPane = new BallPane(); // Create a ball pane

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                ballPane.increaseSize();
            }
            else if (e.getCode() == KeyCode.LEFT) {
                ballPane.decreaseSize();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    public void stop() {
        ballPane.setAlive(false);
    }
}
