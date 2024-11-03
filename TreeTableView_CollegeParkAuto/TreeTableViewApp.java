package com.example.daalgawruud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TreeTableViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TreeTableView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 540);
        primaryStage.setTitle("College Park Auto-Parts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
