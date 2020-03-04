package com.cliente;

import com.sockets.Cliente;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Controller {
    public TextArea chatClient;
    public TextField textClient;
    public TextField clientPuerto;
    private String address;

    public void pressButton(ActionEvent event){
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
    public void IngresarPuerto(ActionEvent event){
        int puerto = Integer.parseInt(clientPuerto.getText());
        clientPuerto.clear();

        Cliente cliente = new Cliente("127.0.0.1", puerto);
        cliente.start();
    }

}

