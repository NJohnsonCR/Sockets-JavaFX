
package com.sockets;

import com.servidor.*;
import javafx.scene.control.TextArea;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor implements Runnable{

    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    public TextArea chatServer;
    public Thread mihilo;

    public Servidor(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for client");

            mihilo = new Thread();
            mihilo.start();
            System.out.println("Thread Iniciado");
        } catch (IOException e) {
            System.out.println(e);;
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                socket = server.accept();
                System.out.println("Client Accepted");
                in = new DataInputStream(socket.getInputStream());
                String mensaje = in.readUTF();
                chatServer.appendText(mensaje + "\n");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}