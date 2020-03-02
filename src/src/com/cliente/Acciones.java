package com.cliente;
import com.sockets.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Acciones {

    public TextArea chatClient;
    public TextField textClient;

    public void EnviarMensaje(){
        if (textClient.getLength() == 0) {
            chatClient.appendText("Primero debes ingresar un texto" + "\n");

        } else {
            String Message;
            Message = textClient.getText();
            chatClient.appendText(Message + "\n");
            textClient.clear();
            System.out.println("Mensaje Enviado");
        }
    }
}
