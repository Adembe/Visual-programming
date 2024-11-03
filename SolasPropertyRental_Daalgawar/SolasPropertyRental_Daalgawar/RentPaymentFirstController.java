package com.example.daalgawruud;

import javafx.application.Platform;
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
import java.time.LocalDate;
import java.util.Locale;

public class RentPaymentFirstController {
    public static ObservableList<RentPayment> list = FXCollections.observableArrayList();
    @FXML
    private TableView<RentPayment> TableViewRentPayment;

    @FXML
    private Button btnNewRentPayment;

    @FXML
    private Button btnRentClose;

    @FXML
    private TableColumn<RentPayment, String> colAllocationCode;

    @FXML
    private TableColumn<RentPayment, String> colAmountReceived;

    @FXML
    private TableColumn<RentPayment, LocalDate> colDateReceived;

    @FXML
    private TableColumn<RentPayment, LocalDate> colPaymentFor;

    @FXML
    private TableColumn<RentPayment, String> colPropertyCode;

    @FXML
    private TableColumn<RentPayment, String> colPropertyType;

    @FXML
    private TableColumn<RentPayment, String> colReceiptNumber;

    @FXML
    private TableColumn<RentPayment, String> colTenantAccount;

    @FXML
    private TableColumn<RentPayment, String> colTenantName;

    @FXML
    void initialize(){
        colDateReceived.setCellValueFactory(new PropertyValueFactory<>("RentPaymentDateRec"));
        colReceiptNumber.setCellValueFactory(new PropertyValueFactory<>("RentPaymentReceipt"));
        colAmountReceived.setCellValueFactory(new PropertyValueFactory<>("RentPaymentAmountReceived"));
        colPropertyType.setCellValueFactory(new PropertyValueFactory<>("RentPaymentPropertyType"));
        colAllocationCode.setCellValueFactory(new PropertyValueFactory<>("RentPaymentAlloCode"));
        colPaymentFor.setCellValueFactory(new PropertyValueFactory<>("RentPaymentFor"));
        colTenantName.setCellValueFactory(new PropertyValueFactory<>("RentPaymentTenantName"));
        colTenantAccount.setCellValueFactory(new PropertyValueFactory<>("RentPaymentTenantAccount"));
        colPropertyCode.setCellValueFactory(new PropertyValueFactory<>("RentPaymentPropertyCode"));
        TableViewRentPayment.setItems(list);
    }
    @FXML
    void NewRentPayment(ActionEvent event) throws IOException {
        Stage newrent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RentPayment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 380);
        newrent.setTitle("Solas Property Rental- Rent Payment");
        newrent.setScene(scene);
        newrent.show();
    }

    @FXML
    void RentClose(ActionEvent event){
        Stage stage  = (Stage) btnRentClose.getScene().getWindow();
        stage.close();
    }

}
