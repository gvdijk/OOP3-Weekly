package week1;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.util.Random;

public class A_14_2 extends Application{

    public void start(Stage primaryStage){
        Random random = new Random();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Image imageX = new Image("img/x.gif");
        Image imageO = new Image("img/O.gif");

        Image[] images = {imageX, imageO, null};

        for(int j=0; j < 3;j++){
            for (int i=0;i < 3;i++){
                pane.add(new ImageView(images[random.nextInt(3)]), i, j);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.show();
    }
}