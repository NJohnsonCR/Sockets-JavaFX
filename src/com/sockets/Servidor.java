
package com.sockets;

import com.servidor.*;
import javafx.scene.control.TextArea;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread{
    //initialize socket and input stream
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    public TextArea chatServer;

    // constructor with port
    public Servidor(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor Comenzado...");
            System.out.println("Esperando Cliente...");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Hola");
                socket = server.accept();
                in = new DataInputStream(socket.getInputStream());
                String mensaje_texto = in.readUTF();
                chatServer.appendText("\n" + mensaje_texto);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}