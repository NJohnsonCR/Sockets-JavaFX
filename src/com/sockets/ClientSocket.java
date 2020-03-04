/**
 * Modularity used for the creation of the package sockets
 */
package com.sockets;
/**
 * Libraries used for the class ClientSocket
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * public class ClientSocket uses inheritance to extend the class Thread in which the thread is created
 */

public class ClientSocket extends Thread {
    /**
     * initialize socket and input output streams attributes
      */
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream out;

    /**
     * constructor to put ip address and port
      */
    public ClientSocket(String address, int port){
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * public void run method is related to the thread created
     */
    @Override
    public void run(){
        try {

            /**
             *  takes input from terminal
             */
            input = new DataInputStream(System.in);
            /**
             *  sends output to the socket
             */
            out = new DataOutputStream(socket.getOutputStream());
        } catch(IOException i) {
            System.out.println(i);
        }

        /**
         *
         *string to read message from input
         */
        String line = "";

        /**
         *  keep reading until "Over" is input
         */
        while (!"Exit".equals(line)) {
            try {
                if (input != null) {
                    line = input.readLine();
                }

                if (out != null) {
                    out.writeUTF(line);
                }
            }
            catch(IOException i) {
                System.out.println(i);
            }
        }

        /**
         * close the connection
         */
        try {
            input.close();
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
        catch(IOException i) {
            System.out.println(i);
        }
    }

}
