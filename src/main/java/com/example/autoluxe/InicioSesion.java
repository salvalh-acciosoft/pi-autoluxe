package com.example.autoluxe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioSesion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = FXMLLoader.load(getClass().getResource("vista_InicioSesion.fxml"));
        Scene scene = new Scene(root, javafx.scene.paint.Color.WHITE);
        stage.setTitle("AutoLuxe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}