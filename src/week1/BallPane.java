package week1;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static java.lang.Thread.sleep;

public class BallPane extends Pane {
    public double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private boolean alive = true;
    private boolean playing = true;
    private int playrate = 50;

    public BallPane() {
        circle.setFill(Color.GREEN); // Set ball color
        getChildren().add(circle); // Place a ball into this pane

        // Create an animation for moving the ball

        new Thread(() -> {
            try {
                while (alive) {
                    if (playing) {
                        Platform.runLater(() -> moveBall());
                    }
                    sleep(playrate);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void pause() { playing = false; }

    public void play() { playing = true; }

    public void decreaseSpeed() { playrate++; }

    public void increaseSpeed() { playrate = playrate > 1 ? playrate - 1 : 1; }

    public void decreaseSize() {
        radius *= 0.9;
        circle.setRadius(radius);
    }

    public void increaseSize() {
        radius *= 1.1;
        circle.setRadius(radius);
    }

    public void nextColor(Circle c) {
        if      (c.getFill() == Color.GREEN) { c.setFill(Color.BLUE); System.out.println("Green"); }
        else if (c.getFill() == Color.BLUE) { c.setFill(Color.RED); System.out.println("Blue"); }
        else if (c.getFill() == Color.RED) { c.setFill(Color.GREEN); System.out.println("Red"); }
    }

    protected void moveBall() {
        // Check boundaries
        if (x < radius || x > getWidth() - radius) {
            dx *= -1; // Change ball move direction
            nextColor(circle);
        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1; // Change ball move direction
            nextColor(circle);
        }

        // Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}