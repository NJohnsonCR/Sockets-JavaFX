package com.servidor;

import com.sockets.Servidor;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class Controller{
    public TextField IngresarPuerto;

    public void pressButton(ActionEvent event){

    }
    public void ponerPuerto(ActionEvent event){
        int puerto = Integer.parseInt(IngresarPuerto.getText());
        IngresarPuerto.clear();
        com.sockets.Servidor servidor = new Servidor(puerto);
        servidor.start();
    }
}
