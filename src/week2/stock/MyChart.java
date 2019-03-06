package week2.stock;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.LineChart; 
import javafx.scene.chart.NumberAxis; 
import javafx.scene.chart.XYChart; 
         
public class MyChart extends Application { 
    // series s is used in seperate thread (must be static)
    static XYChart.Series s; 

    @Override 
    public void start(Stage stage) {
        // defining the x&y axis             
        NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
        xAxis.setLabel("Years"); 
        NumberAxis yAxis = new NumberAxis(0, 350, 50); 
        yAxis.setLabel("Nr of schools");
        
        // creating the line chart 
        LineChart linechart = new LineChart(xAxis, yAxis);  
        linechart.setTitle("Nr of schools in a year"); 

        // defining a series
        s = new XYChart.Series();        
        s.setName("My Chart");
        linechart.getData().add(s);

        Group root = new Group(linechart); 
        Scene scene = new Scene(root, 600, 400);  
        stage.setScene(scene);
        stage.show();         

        Thread t = new Thread(new Test());
        t.start();
    }

    // inner class
    class Test implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Platform.runLater(()->MyChart.s.getData().add(new XYChart.Data(1970, 15))); 
                Thread.sleep(1000);
                Platform.runLater(()->MyChart.s.getData().add(new XYChart.Data(1980, 30))); 
                Thread.sleep(1000);
                Platform.runLater(()->MyChart.s.getData().add(new XYChart.Data(1990, 60))); 
                Thread.sleep(1000);
                Platform.runLater(()->MyChart.s.getData().add(new XYChart.Data(2000, 120))); 
                Thread.sleep(1000);
                Platform.runLater(()->MyChart.s.getData().add(new XYChart.Data(2010, 240))); 
            } catch (InterruptedException ex) {
            }
        }
    }
}

