package com.servidor;

/**
 * All libraries used in Controller class for the server GUI
 */

import com.sockets.ServerSocket;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

/**
 * public class Controller manages all the button`s functionality
 */
public class Controller{
    /**
     * Atributte inputPortServer used for setting the port you wanna set your server in
     */
    public TextField inputPortServer;

    /**
     *public void pressButton uses ActionEvent to execute an action
     */

    public void pressButton(ActionEvent event){

    }
    /**
     * public vid writePort is used for setting the port for your server
     */
    public void writePort(ActionEvent event){
        int puerto = Integer.parseInt(inputPortServer.getText());
        inputPortServer.clear();
        ServerSocket serverSocket = new ServerSocket(puerto);
        serverSocket.start();
    }
}
