package week4.chatprogram.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientView extends Application {

    //JavaFX components
    private Scene scene;
    //Chat view components
    private TextField chatField;
    private VBox chatVBox;
    private Text chatNameField;
    private TextArea chatArea;
    //Initial view components
    private TextField usernameField;
    //Other class variables
    private StringBuilder chatHistory;
    private String name;
    private ClientThread messageThread;

    public static void main (String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        chatHistory = new StringBuilder();

        primaryStage.setTitle("ChatApp Client");
        //Create a VBox to hold all initial view components
        VBox initialViewBox = new VBox();
        initialViewBox.setAlignment(Pos.CENTER);
        initialViewBox.setPadding(new Insets(25, 5, 25, 5));
        initialViewBox.setPrefSize(800, 400);
        initialViewBox.setSpacing(10);

        //Create all components for the initial view
        Text usernameText = new Text("Welcome. Please enter a username.");
        usernameText.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        usernameField = new TextField();
        usernameField.setMaxWidth(300);
        Button setUsernameButton = new Button("Submit Username");
        setUsernameButton.setOnAction(event-> {
            String text = usernameField.getText();
            if (text.equals("")) name = null;
            else name = text;
            showChatView();
        });

        //Add the components of the initial view
        initialViewBox.getChildren().add(usernameText);
        initialViewBox.getChildren().add(usernameField);
        initialViewBox.getChildren().add(setUsernameButton);

        //Create HBox to hold the chatfield and the send button
        HBox chatHBox = new HBox();
        chatHBox.setSpacing(10);

        //Create a VBox to hold all chat components
        chatVBox = new VBox();
        chatVBox.setAlignment(Pos.CENTER);
        chatVBox.setPadding(new Insets(25, 5, 25, 5));
        chatVBox.setPrefSize(800, 400);
        chatVBox.setSpacing(10);

        //Create the label that states the username of the client
        chatNameField = new Text();
        chatNameField.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        //Create textarea for the chatfield
        chatArea = new TextArea();
        chatArea.setWrapText(true);
        chatArea.setPrefSize(800, 400);
        chatArea.setEditable(false);

        //Create the textfield for the user to type in
        chatField = new TextField();
        chatField.setPrefWidth(550);
        //Create the send button to send the message
        Button sendButton = new Button("Send Message");
        sendButton.setOnAction(event->{
            messageThread.sendMessage(chatField.getText());
            chatField.clear();
        });
        //Add the textfield for the users to type in to the HBox
        chatHBox.getChildren().add(chatField);
        //Add the Button to the HBox
        chatHBox.getChildren().add(sendButton);

        //Add the label that states the username to the VBox
        chatVBox.getChildren().add(chatNameField);
        //Add the textarea for the chatfield to the VBox
        chatVBox.getChildren().add(chatArea);
        //Add textfield and send button to application VBox
        chatVBox.getChildren().add(chatHBox);

        scene = new Scene(initialViewBox);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                String text = usernameField.getText();
                if (text.equals("")) name = null;
                else name = text;
                showChatView();
            }
        });

        primaryStage.setOnCloseRequest(event -> messageThread.sendMessage("ByeBye"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showChatView(){
        String chatName = "Your chat name: ";
        if (name == null) name = "Anonymous";
        chatName += name;

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                messageThread.sendMessage(chatField.getText());
                chatField.clear();
            }
        });

        messageThread = new ClientThread("localhost", 8000, name, this);
        Thread thread = new Thread(messageThread);
        thread.start();

        chatNameField.setText(chatName);
        scene.setRoot(chatVBox);
    }

    public void updateChatHistory(String text){
        chatHistory.append(text);
        chatHistory.append("\n");
        Platform.runLater(() -> chatArea.setText(chatHistory.toString()));
    }
}
