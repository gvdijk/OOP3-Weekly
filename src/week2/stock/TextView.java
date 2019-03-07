package week2.stock;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public class TextView implements View  {
    private HashMap<String, Label> stocks;
    private ArrayList<StockObserver> stockObservers;
    private VBox pane;

    public TextView(ArrayList<StockObserver> stockObservers) {
        pane = new VBox();
        stocks = new HashMap<>();

        this.stockObservers = stockObservers;
        for (StockObserver so : stockObservers) {
            so.register(this);
        }
    }

    @Override
    public void update(String stockName, double stockPrice) {
        if (stocks.get(stockName) == null) {
            Label l = new Label(stockName);
            stocks.put(stockName, l);
            Platform.runLater(() -> pane.getChildren().add(l));
        }
        Platform.runLater(() -> stocks.get(stockName).setText(stockName + ": " + stockPrice));
    }

    @Override
    public Pane getPane() {
        return pane;
    }
}
