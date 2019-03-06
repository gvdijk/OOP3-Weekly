package week2.stock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// the Client
public class StockApp extends Application {
    public void start(Stage primaryStage) {

        Pane pane = new GridPane();

        // create concrete subject
        StockGrabber stockGrabber = new StockGrabber();

        // create and register concrete observer
        StockObserver observer1 = new StockObserver(stockGrabber);


        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Yes");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();


        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAAPLPrice(677.60);
        stockGrabber.setGOOGPrice(676.40);
    }
}

