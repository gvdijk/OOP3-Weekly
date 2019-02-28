package week1;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static java.lang.Thread.sleep;

public class BallPane extends Pane {
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private boolean playing = true;
    private int playrate = 50;

    public BallPane() {
        circle.setFill(Color.GREEN); // Set ball color
        getChildren().add(circle); // Place a ball into this pane

        // Create an animation for moving the ball

        new Thread(() -> {
            try {
                while (true) {
                    if (playing) {
                        Platform.runLater(() -> moveBall());
                    }
                    sleep(playrate);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("Oui");
    }

    public void pause() { playing = false; }

    public void play() { playing = true; }

    public void decreaseSpeed() { playrate++; }

    public void increaseSpeed() { playrate = playrate > 1 ? playrate - 1 : 1; }

    protected void moveBall() {
        // Check boundaries
        if (x < radius || x > getWidth() - radius) {
            dx *= -1; // Change ball move direction
        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}