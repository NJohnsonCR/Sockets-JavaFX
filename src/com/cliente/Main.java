/**
 * used modularity for creating te
 */
package com.cliente;
/**
 * All the libraries used in the making of the main class of the client GUI
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * public class Main creates the scene where you do all the interactions, it also uses inheritance
 */
public class Main extends Application {
    /**
     *Public void start calls the .fxml file that you are working with and creates the scene
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    /**
     *Executes the GUI
     */

    public static void main(String[] args) {
        launch(args);
    }
}
