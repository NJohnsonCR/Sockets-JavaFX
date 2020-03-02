package com.servidor;

import javafx.event.ActionEvent;
import com.sockets.*;
import javafx.scene.control.TextField;


public class Controller{
    public TextField IngresarPuerto;

    public void pressButton(ActionEvent event){

    }
    public void ponerPuerto(ActionEvent event){
        int puerto = Integer.parseInt(IngresarPuerto.getText());
        IngresarPuerto.clear();
        Servidor servidor = new Servidor(puerto);
        servidor.start();
    }
}
