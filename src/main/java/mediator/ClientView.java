package mediator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientView {
    private BorderPane borderPane;
    private TextArea chatBox;
    private TextField messageBox;
    private ComboBox userBox;
    private Button sendButton;
    private Stage stage;
    public ClientView() {
        borderPane = new BorderPane();
        stage = new Stage();
        chatBox = new TextArea();
        messageBox = new TextField();
        userBox = new ComboBox();
        sendButton = new Button("Send");
        messageBox.setPromptText("Enter message");
        chatBox.setEditable(false);

        messageBox.setMinHeight(50);
        borderPane.setCenter(chatBox);
        borderPane.setBottom(messageBox);
        borderPane.setLeft(userBox);
        borderPane.setRight(sendButton);
        stage.setScene(new Scene(borderPane, 400, 400));

    }



    public TextField getMessageBox() {
        return messageBox;
    }

    public ComboBox getUserBox() {
        return userBox;
    }

    public Button getSendButton() {
        return sendButton;
    }


    public void display() {
        stage.show();



    }
    public void setTitle(String title) {
        stage.setTitle(title);
    }

    public void updateChatBox(Message message) {
        chatBox.appendText(message.getSender()+"@"+message.getReceiver()+": "+message.getMessage()+"\n");

    }







}
