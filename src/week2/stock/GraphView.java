package week2.stock;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphView implements View{
    private HashMap<String, XYChart.Series> stocks;
    private LineChart linechart;

    private ArrayList<StockObserver> stockObservers;
    private GridPane pane;

    private int faketime = 0;

    public GraphView(ArrayList<StockObserver> stockObservers) {
        stocks = new HashMap<>();
        pane = new GridPane();
        chart();
        this.stockObservers = stockObservers;
        for (StockObserver so : stockObservers) {
            so.register(this);
        }
    }

    @Override
    public void update(String stockName, double stockPrice) {
        faketime++;
        if (stocks.get(stockName) == null) {
            XYChart.Series s = new XYChart.Series();
            s.setName(stockName);
            Platform.runLater(() -> linechart.getData().add(s));
            stocks.put(stockName, s);
        }
        Platform.runLater(() -> stocks.get(stockName).getData().add(new XYChart.Data(faketime, stockPrice)));
    }


    public void chart() {
        // defining the x&y axis
        NumberAxis xAxis = new NumberAxis(0, 50, 1);
        xAxis.setLabel("Timeunit");
        NumberAxis yAxis = new NumberAxis(0, 1000, 50);
        yAxis.setLabel("Stockprice");

        // creating the line chart
        linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("Stockprice history");

        this.pane.add(linechart, 0, 0);
    }

    @Override
    public Pane getPane() {
        return pane;
    }
}
