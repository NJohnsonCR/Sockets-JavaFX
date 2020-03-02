package com.sockets;

import com.cliente.*;
import com.servidor.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public TextArea chatClient;

    public Cliente(String address, int port){

        try {

            socket = new Socket(address, port);

            in = new DataInputStream(System.in);

            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(chatClient.getText());

            out.close();

        } catch (IOException e) {

            System.out.println(e);
        }

    }

}
