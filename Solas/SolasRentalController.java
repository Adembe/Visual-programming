package com.example.daalgawruud;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SolasRentalController {
    @FXML
    private Button btnClose;

    @FXML
    private Button btnRentPayment;

    @FXML
    private Button btnRentalAllocations;

    @FXML
    private Button btnRentalProperties;

    @FXML
    private Button btnTenants;

    @FXML
    void Close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void RentPayment(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RentPaymentFirst.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        rent.setTitle("Solas Property Rental- Rent Payment");
        rent.setScene(scene);
        rent.show();
    }

    @FXML
    void RentalAllocations(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RentalAllocationsFirst.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 814, 400);
        rent.setTitle("Solas Property Rental- Rent Allocation");
        rent.setScene(scene);
        rent.show();
    }

    @FXML
    void RentalProperties(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PropertiesFirst.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 350);
        rent.setTitle("Solas Property Rental- Properties Listing");
        rent.setScene(scene);
        rent.show();
    }

    @FXML
    void Tenants(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TenantsFirst.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        rent.setTitle("Solas Property Rental- Tenants");
        rent.setScene(scene);
        rent.show();
    }
}
