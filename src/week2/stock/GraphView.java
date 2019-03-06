package week2.stock;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GraphView implements View{
    private XYChart.Series stockIBM;
    private XYChart.Series stockAAPL;
    private XYChart.Series stockGOOG;

    private ViewSubject stockObserver;
    private GridPane pane;

    private int faketime = 0;

    public GraphView(StockObserver stockObserver) {
        pane = new GridPane();
        chart();
        this.stockObserver = stockObserver;
        stockObserver.register(this);
    }

    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        faketime++;
        stockIBM.getData().add(new XYChart.Data(faketime, ibmPrice));
        stockAAPL.getData().add(new XYChart.Data(faketime, aaplPrice));
        stockGOOG.getData().add(new XYChart.Data(faketime, googPrice));
    }


    public void chart() {
        // defining the x&y axis
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("Timeunit");
        NumberAxis yAxis = new NumberAxis(0, 1000, 50);
        yAxis.setLabel("Stockprice");

        // creating the line chart
        LineChart linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("Stockprice history");

        // defining a series
        stockIBM = new XYChart.Series();
        stockAAPL = new XYChart.Series();
        stockGOOG = new XYChart.Series();
        stockIBM.setName("IBM");
        stockAAPL.setName("AAPL");
        stockGOOG.setName("GOOG");

        linechart.getData().add(stockIBM);
        linechart.getData().add(stockAAPL);
        linechart.getData().add(stockGOOG);

        this.pane.add(linechart, 0, 0);
    }

    @Override
    public Pane getPane() {
        return pane;
    }
}
