package com.sockets;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {
    // initialize socket and input output streams
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream out;

    // constructor to put ip address and port
    public Cliente(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            // takes input from terminal
            input = new DataInputStream(System.in);
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch(IOException i) {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
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

        // close the connection
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

    public static void main(String [] args) {
        Cliente cliente = new Cliente("127.0.0.1", 6969);
    }
}




