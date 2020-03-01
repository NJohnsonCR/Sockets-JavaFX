
package com.sockets;

import com.servidor.*;
import javafx.scene.control.TextArea;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor{

    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    public TextArea chatServer;
    public Thread mihilo;

    public Servidor(int port) {
        System.out.println("Thread corriendo...");
        try {
            server = new ServerSocket(port);

            System.out.println("Server started");

            System.out.println("Waiting for a client");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String string = "";
            while(true){
                try{
                    string = in.readUTF();
                    chatServer.appendText(string);
                    socket.close();

                }catch (IOException e1){
                    System.out.println(e1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

