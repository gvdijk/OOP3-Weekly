package week2.stock;

import javafx.scene.layout.Pane;

public interface View {

    public void update(String stockName, double stockPrice);
    public Pane getPane();
}
