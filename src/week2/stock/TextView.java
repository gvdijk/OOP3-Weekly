package week2.stock;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TextView implements View  {
    private Label name;
    private Label stockIBM;
    private Label stockAAPL;
    private Label stockGOOG;

    private ViewSubject stockObserver;
    private GridPane pane;

    public TextView(StockObserver stockObserver) {
        this.stockObserver = stockObserver;
        pane = new GridPane();

        name = new Label("Textview: ");
        stockIBM = new Label("IBM: ");
        stockAAPL = new Label("AAPL: ");
        stockGOOG = new Label("GOOG: ");

        pane.add(name, 0, 0);
        pane.add(stockIBM, 0, 1);
        pane.add(stockAAPL, 0, 2);
        pane.add(stockGOOG, 0, 3);

        stockObserver.register(this);
    }

    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        stockIBM.setText("IBM: " + ibmPrice);
        stockAAPL.setText("AAPL: " + aaplPrice);
        stockGOOG.setText("GOOG: " + googPrice);
    }

    @Override
    public Pane getPane() {
        return pane;
    }
}
