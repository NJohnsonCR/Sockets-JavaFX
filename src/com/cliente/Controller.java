package com.cliente;
/**
 * Libraries used in class client
 */
import com.sockets.ClientSocket;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * Public class controller is used for managing the functionality of the GUI buttons
 */
public class Controller {
    /**
     *Atributes used in class controller
     */
    public TextArea chatClient;
    public TextField textClient;
    public TextField inputPort;
    /**
     * private variable it means encapsulation was used
     */
    private String address;

    /**
     *method pressButton used for inputting the string into the chatbox
     */

    public void pressButton(ActionEvent event){
        /**
         * If textclient lenght is equal to cero in returns "Primero debes ingresae un texto"
         */
        if (textClient.getLength() == 0) {
            chatClient.appendText("Primero debes ingresar un texto" + "\n");

        } else {
            /**
             * If you write a string it will input the string into the chatbox
             */
            String Message;
            Message = textClient.getText();
            chatClient.appendText(Message + "\n");
            textClient.clear();
            System.out.println("Mensaje Enviado");
        }
    }

    /**
     *public void IngresarPuerto its used to input the port you want to use in the client and the it sends it to com.server class
     */
    public void IngresarPuerto(ActionEvent event){
        int puerto = Integer.parseInt(inputPort.getText());
        inputPort.clear();

        ClientSocket clientSocket = new ClientSocket("127.0.0.1", puerto);
        clientSocket.start();
    }

}

