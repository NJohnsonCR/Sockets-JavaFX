package servidor;

import javafx.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.control.*;
import javax.swing.*;

public class Controller {
    public TextArea chatServer;
    public TextField textServer;

    public void pressButton(ActionEvent event) {
        if (textServer.getLength() == 0) {
            chatServer.appendText("Ingresa un texto" + "\n");
        } else {
            String Message;
            Message = textServer.getText();
            chatServer.appendText(Message + "\n");
            textServer.clear();
        }
    }
    public class SocketServidor{
        ServerSocket servidor
    }
}
