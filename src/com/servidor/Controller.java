package com.servidor;

import javafx.event.ActionEvent;

import java.io.*;
import java.net.*;
import javafx.scene.control.*;
import javax.swing.*;
import com.sockets.*;

public class Controller implements Runnable {
    Thread mihilo=new Thread(this);
    
    @Override
    public void run() {

        Servidor servidor = new Servidor(6969);
    }
}
