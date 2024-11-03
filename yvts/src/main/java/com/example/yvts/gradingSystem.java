package com.example.yvts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class gradingSystem extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gradingSystem.fxml"));
        primaryStage.setTitle("Grading System");
        primaryStage.setScene(new Scene(root, 500, 760));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}