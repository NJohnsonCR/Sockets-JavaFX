/**
 * Modularity used for the creation of the package socktes
 */
package com.sockets;
/**
 * All the libraries used in the class ServerSocket
 */

import javafx.scene.control.TextArea;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * public class ServerSocket uses inheritance for extending the java class Thread
 */
public class ServerSocket extends Thread{
    /**
     * initialize socket and input stream attributes, used encapsulation to set the attributes private
     */
    private Socket socket;
    private java.net.ServerSocket server;
    private DataInputStream in;
    public TextArea chatServer;

    /**
     * constructor to put the port
     */
    public ServerSocket(int puerto) {
        /**
         *starts server and waits for a connection
         */
        try {
            server = new java.net.ServerSocket(puerto);
            System.out.println("Port " + puerto + " assigned");
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * public void run method is created when the thread is used
     */
    @Override
    public void run() {
        try {
        socket = server.accept();
        System.out.println("Client accepted");

            /**
             * takes input from the client socket
             */
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String line = "";

            /**
             *  reads message from client until "Over" is sent
             */
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

            /**
             *close connection
             */
        socket.close();
        in.close();
         }
        catch(IOException i) {
            System.out.println(i);
         }
    }

}