package sample;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.Socket;


public class Controller {
    public void pressButton(ActionEvent event){
        try {
            Socket misocket=new Socket("122.0.0.1", 6969);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
