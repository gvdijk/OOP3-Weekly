package week1;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class A_14_16 extends Application{
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        pane.setPrefSize(600, 600);

        //Two horizontal lines
        Line hLine1 = new Line();
        Line hLine2 = new Line();
        hLine1.setStroke(Color.BLUE);
        hLine2.setStroke(Color.BLUE);
        hLine1.endXProperty().bind(pane.widthProperty());
        hLine2.endXProperty().bind(pane.widthProperty());
        hLine1.startYProperty().bind(pane.heightProperty().divide(3));
        hLine1.endYProperty().bind(pane.heightProperty().divide(3));
        hLine2.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        hLine2.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));

        //Two vertical lines
        Line vLine1 = new Line();
        Line vLine2 = new Line();
        vLine1.setStroke(Color.RED);
        vLine2.setStroke(Color.RED);
        vLine1.endYProperty().bind(pane.heightProperty());
        vLine2.endYProperty().bind(pane.heightProperty());
        vLine1.startXProperty().bind(pane.widthProperty().divide(3));
        vLine1.endXProperty().bind(pane.widthProperty().divide(3));
        vLine2.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        vLine2.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));

        pane.getChildren().add(hLine1);
        pane.getChildren().add(hLine2);
        pane.getChildren().add(vLine1);
        pane.getChildren().add(vLine2);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3*3 grid");
        primaryStage.show();
    }
}