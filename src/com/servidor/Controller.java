package com.servidor;

import javafx.event.ActionEvent;
import com.sockets.*;

public class Controller{

    public void pressButton(ActionEvent event){
        Servidor servidor = new Servidor(6969);
        servidor.start();
        System.out.println("Thread comenzado... ");
    }
}
