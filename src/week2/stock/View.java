package week2.stock;

import javafx.scene.layout.Pane;

public interface View {

    public void update(double ibmPrice,
                       double aaplPrice, double googPrice);

    public Pane getPane();
}
