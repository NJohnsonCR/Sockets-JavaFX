
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


    public Servidor(int puerto) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(puerto);
            System.out.println("Port " + puerto + " assigned");
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        try {
        socket = server.accept();
        System.out.println("Client accepted");

        // takes input from the client socket
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String line = "";

        // reads message from client until "Over" is sent
        while (!line.equals("Over")) {
            try {
                line = in.readUTF();
                System.out.println(line);

            }
            catch(IOException i) {
                System.out.println(i);
            }
        }
        System.out.println("Closing connection");

        // close connection
        socket.close();
        in.close();
         }
        catch(IOException i) {
            System.out.println(i);
         }
    }

}