package week1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class A_15_4 extends Application {
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setPadding(new Insets(10, 10, 10 ,10));
        hbox2.setSpacing(50);
        hbox2.setAlignment(Pos.CENTER);

        pane.setVgap(10);
        pane.setHgap(10);

        //Number 1
        Label label1 = new Label("Number 1:");
        hbox1.getChildren().add(label1);
        TextField field1 = new TextField();
        hbox1.getChildren().add(field1);
        //Number 2
        Label label2 = new Label("Number 2:");
        hbox1.getChildren().add(label2);
        TextField field2 = new TextField();
        hbox1.getChildren().add(field2);
        //Result
        Label resultLabel = new Label("Result:");
        hbox1.getChildren().add(resultLabel);
        TextField resultField = new TextField();
        hbox1.getChildren().add(resultField);

        //Add button
        Button addButton = new Button("+");
        addButton.setOnAction(actionEvent -> calc(field1, field2, resultField, "add"));
        hbox2.getChildren().add(addButton);
        //Subtract button
        Button subButton = new Button("-");
        subButton.setOnAction(actionEvent -> calc(field1, field2, resultField, "sub"));
        hbox2.getChildren().add(subButton);
        //Multiply button
        Button mulButton = new Button("*");
        mulButton.setOnAction(actionEvent -> calc(field1, field2, resultField, "mul"));
        hbox2.getChildren().add(mulButton);
        //Divide button
        Button divButton = new Button("/");
        divButton.setOnAction(actionEvent -> calc(field1, field2, resultField, "div"));
        hbox2.getChildren().add(divButton);

        pane.add(hbox1, 0, 0);
        pane.add(hbox2, 0, 1);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    void calc (TextField a, TextField b, TextField result, String mode){
        double first;
        double second;
        try {
            first = Double.parseDouble(a.getText());
            second = Double.parseDouble(b.getText());
        } catch (NumberFormatException e) {
            result.setText("NaN");
            return;
        }

        double calcResult = 0;
        switch (mode) {
            case "add": calcResult = first + second;
                break;
            case "sub": calcResult = first - second;
                break;
            case "mul": calcResult = first * second;
                break;
            case "div": calcResult = first / second;
                break;
        }

        result.setText(Double.toString(calcResult));
    }

}
