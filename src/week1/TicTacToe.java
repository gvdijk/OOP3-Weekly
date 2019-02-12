package week1;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.Random;

public class TicTacToe extends Application{

    public static void main(String[] args){
        launch();
    }

    public TicTacToe(){

    }

    public void start(Stage primaryStage){
        Random random = new Random();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Image imageX = new Image("img/x.gif");
        Image imageO = new Image("img/O.gif");

        Image[] images = {imageX, imageO};

        for(int j=0; j < 3;j++){
            for (int i=0;i < 3;i++){
                pane.add(new ImageView(images[random.nextInt(2)]), i, j);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.show();
    }
}