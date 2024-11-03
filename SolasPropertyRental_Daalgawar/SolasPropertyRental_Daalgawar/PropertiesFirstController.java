package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertiesFirstController {
    public static ObservableList<Properties> list3 = FXCollections.observableArrayList();
    @FXML
    private TableView<Properties> TableViewProperty;
    @FXML
    private TableColumn<Properties, String> colBathrooms;

    @FXML
    private TableColumn<Properties, String> colBedrooms;

    @FXML
    private TableColumn<Properties, String> colMonthlyRent;

    @FXML
    private TableColumn<Properties, String> colPropertyCode;

    @FXML
    private TableColumn<Properties, String> colPropertyType;

    @FXML
    private TableColumn<Properties, String> colStatus;
    @FXML
    private Button btnNewProperty;

    @FXML
    private Button btnPropertyClose;
    @FXML
    void initialize(){
        colBathrooms.setCellValueFactory(new PropertyValueFactory<>("PropertyBathrooms"));
        colBedrooms.setCellValueFactory(new PropertyValueFactory<>("PropertyBedrooms"));
        colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("PropertyMonthlyRent"));
        colPropertyCode.setCellValueFactory(new PropertyValueFactory<>("PropertyCode"));
        colPropertyType.setCellValueFactory(new PropertyValueFactory<>("PropertyType"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("PropertyOccupancyStatus"));
        TableViewProperty.setItems(list3);
    }


    @FXML
    void NewProperty(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Properties.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 260);
        rent.setTitle("Solas Property Rental- Property Editor");
        rent.setScene(scene);
        rent.show();
    }

    @FXML
    void PropertyClose(ActionEvent event) {
        Stage stage  = (Stage) btnPropertyClose.getScene().getWindow();
        stage.close();
    }
}
