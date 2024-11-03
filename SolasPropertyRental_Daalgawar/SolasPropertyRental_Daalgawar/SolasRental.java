package com.example.daalgawruud;

import com.example.daalgawruud.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SolasRental extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SolasPropertyRental.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);
        primaryStage.setTitle("Solas Property Rental");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
