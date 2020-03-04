/**
 * used modularity for creating the package com.servidor
 */
package com.servidor;
/**
 * All the libraries used in class com.Main
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * public class Main calls the fmxml document serverGUI.fxml and creates the scene
 */
public class Main extends Application {
    /**
     *public void start creates the scene
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("serverGUI.fxml"));
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }
    /**
     * public static void main launches the program`s GUI
     */

    public static void main(String[] args) {
        launch(args);
    }
}
