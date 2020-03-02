package com.sockets;

import com.cliente.*;
import com.servidor.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;

public class Cliente extends Thread {
    // establish a connection
    private Socket socket;
    private DataInputStream  input;
    private DataOutputStream out ;
    public TextArea textClient;

    public Cliente(String address, int port){
        try{
            socket=new Socket(address, port);
        }catch (IOException e){
            System.out.println(e);
        }


    }
    @Override
    public void run() {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(textClient.getText());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




