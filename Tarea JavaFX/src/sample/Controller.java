package sample;

import javafx.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.*;

public class Controller {

    public TextArea chatClient;
    public TextField textClient;

    public void pressButton(ActionEvent event){
        if (textClient.getLength() == 0) {
            chatClient.appendText("Ingresa un texto" + "\n");
        } else {
            String Message;
            Message = textClient.getText();
            chatClient.appendText(Message + "\n");
            textClient.clear();
        }
        SocketCliente accion_socket = new SocketCliente();
        accion_socket.MandarSocket();
    }
    public class SocketCliente{

        public void MandarSocket(){
            Socket socket_client;
            {
                try {
                    socket_client = new Socket("122.0.0.1", 6969);

                    DataOutputStream salida_socket = new DataOutputStream(socket_client.getOutputStream());

                    salida_socket.writeUTF(chatClient.getText());

                    salida_socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
