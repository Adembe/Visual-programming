package com.example.lab8_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;

    private partEditorController partController;


    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        primaryStage.setTitle("College Park Auto-Parts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void partEditor(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("partEditor.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Stage parEdtorStage = new Stage();
            parEdtorStage.setTitle("Part Editor");
            parEdtorStage.initModality(Modality.APPLICATION_MODAL);
            parEdtorStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            parEdtorStage.setScene(scene);
            partController = fxmlLoader.getController();
            partController.setStage(parEdtorStage);
            parEdtorStage.show();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();
    }
}