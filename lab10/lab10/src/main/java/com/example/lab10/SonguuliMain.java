package com.example.lab10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SonguuliMain extends Application {

    Button startButton = new Button("Start");
    boolean onceStarted = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        startButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                if (onceStarted)
                {
                    service.restart();
                }
                else
                {
                    service.start();
                    onceStarted = true;
                    startButton.setText("Restart");
                }
            }
        });


        GridPane pane = new SonguuliGUI();
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(startButton);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: BLACK;");
        Scene scene = new Scene(root,300,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ерөнхийлөгчийн сонгууль");
        primaryStage.show();

    }

    Service<ObservableList<Integer>> service = new Service<ObservableList<Integer>>() {
        @Override
        protected Task<ObservableList<Integer>> createTask() {
            return new SonguuliTask();
        }
    };
}
