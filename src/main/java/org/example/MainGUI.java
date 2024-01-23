package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("process-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Processing file");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
