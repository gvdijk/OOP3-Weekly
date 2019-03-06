package week2.stock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

// the Client
public class StockApp extends Application {

    private ArrayList<View> views = new ArrayList<>();

    public void start(Stage primaryStage) {

        // create concrete subject
        StockGrabber stockGrabber = new StockGrabber();

        // create and register concrete observer
        StockObserver observer1 = new StockObserver(stockGrabber);


        GridPane pane = new GridPane();
        Button b1 = new Button("Text");
        Button b2 = new Button("Graph");
        TextView v1 = new TextView(observer1);
        views.add(v1);
        GraphView v2 = new GraphView(observer1);
        views.add(v2);
        b1.setOnAction(e -> switchView(v1));
        b2.setOnAction(e -> switchView(v2));
        pane.add(b1 , 0, 0);
        pane.add(b2, 1, 0);
        pane.add(v1.getPane(), 0, 1, 2, 1);
        pane.add(v2.getPane(), 0, 1, 2, 1);

        switchView(v1);

        Scene scene = new Scene(pane, 500, 320);
        primaryStage.setTitle("Amazing Stockviewer 900");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();

        Thread t1 = new Thread(new GetTheStock(stockGrabber));
        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAAPLPrice(677.60);
        stockGrabber.setGOOGPrice(676.40);

        stockGrabber.setIBMPrice(297.00);
        stockGrabber.setAAPLPrice(577.60);
        stockGrabber.setGOOGPrice(626.40);
    }

    void switchView(View v) {
        for (View view : views) {
            view.getPane().setVisible(false);
        }
        v.getPane().setVisible(true);
    }
}

