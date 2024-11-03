package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.daalgawruud.PropertiesFirstController.list3;

public class PropertiesController {
    @FXML
    private TextField PropertyBathrooms;

    @FXML
    private TextField PropertyBedrooms;

    @FXML
    private TextField PropertyCode;

    @FXML
    private TextField PropertyMonthlyRent;

    @FXML
    private ComboBox<String> PropertyOccupancyStatus;
    @FXML
    ObservableList<String> ListOne = FXCollections.observableArrayList("Unknown",
            "Apartment",
            "Townhouse",
            "Single Family");

    @FXML
    private ComboBox<String> PropertyType;
        ObservableList<String> ListTwo = FXCollections.observableArrayList("Unknown",
                "Available",
                "Occupied",
                "Needs Repair");
    @FXML
    private Button btnPropertyCancel;

    @FXML
    private Button btnPropertyOK;
    @FXML
    void initialize(){
        PropertyOccupancyStatus.setItems(ListOne);
        PropertyType.setItems(ListTwo);
        PropertyBedrooms.setText("0");
        PropertyBathrooms.setText("0.00");
        PropertyMonthlyRent.setText("0.00");
        PropertyType.setValue("Unknown");
        PropertyOccupancyStatus.setValue("Unknown");
    }

    @FXML
    void PropertyCancel(ActionEvent event) {
        Stage stage  = (Stage) btnPropertyCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void PropertyOK(ActionEvent event) {
        Properties obj = new Properties();
        PropertyBathrooms.getText();
        obj.setPropertyBathrooms(PropertyBathrooms.getText());
        PropertyBedrooms.getText();
        obj.setPropertyBedrooms(PropertyBedrooms.getText());
        PropertyCode.getText();
        obj.setPropertyCode(PropertyCode.getText());
        PropertyMonthlyRent.getText();
        obj.setPropertyMonthlyRent(PropertyMonthlyRent.getText());
        PropertyOccupancyStatus.getValue();
        obj.setPropertyOccupancyStatus(PropertyOccupancyStatus.getValue());
        PropertyType.getValue();
        obj.setPropertyType(PropertyType.getValue());
        list3.add(obj);
    }
}
