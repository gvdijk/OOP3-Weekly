package week1;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class A_16_4 extends Application{
    public void start(Stage primaryStage){
        double width = 50;
        double height = 50;
        boolean black = true;

        Pane pane = new Pane();

        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                Rectangle box = new Rectangle(j*width, i*height, width, height);
                if(black) {black=false; box.setFill(Color.WHITE);}
                else {black=true; box.setFill(Color.BLACK);}
                pane.getChildren().add(box);
                System.out.println("x = " + j*width + ", y = " + i*height);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Checkerboard");
        primaryStage.show();
    }
}