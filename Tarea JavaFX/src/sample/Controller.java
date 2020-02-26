package sample;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.*;



public class Controller {

    public TextArea chatClient;

    public TextField textClient;


    public void pressButton(ActionEvent event){
        String Message;
        Message = textClient.getText();
        chatClient.appendText(Message + "\n");
        textClient.clear();
    }
}
