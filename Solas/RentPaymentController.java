package com.example.daalgawruud;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.daalgawruud.RentPaymentFirstController.list;

public class RentPaymentController {

    @FXML
    private TextField RentPaymentAlloCode;

    @FXML
    private TextField RentPaymentAmountReceived;

    @FXML
    private DatePicker RentPaymentDateRec;

    @FXML
    private ComboBox<String> RentPaymentMonth;
    @FXML
    ObservableList<String> comboList = FXCollections.observableArrayList("January" ,
            "February",
            "March" ,
            "April" ,
            "May" ,
            "June" ,
            "July" ,
            "August" ,
            "September",
            "October" ,
            "November" ,
            "December");

    @FXML
    private TextField RentPaymentPropertyType;

    @FXML
    private TextField RentPaymentPropertyCode;

    @FXML
    private TextField RentPaymentReceipt;

    @FXML
    private TextField RentPaymentTenantAccount;

    @FXML
    private TextField RentPaymentTenantName;

    @FXML
    private TextField RentPaymentYear;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRentPaymentOK;
    @FXML
    void initialize(){
        RentPaymentMonth.setItems(comboList);
        RentPaymentAmountReceived.setText("0.00");
    }
    @FXML
    void Cancel(ActionEvent event){
        Stage stage  = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    void RentPaymentOk(ActionEvent event) {
        RentPayment temp = new RentPayment();
        RentPaymentDateRec.getValue();
        temp.setRentPaymentDateRec(RentPaymentDateRec.getValue());
        RentPaymentReceipt.getText();
        temp.setRentPaymentReceipt(RentPaymentReceipt.getText());
        RentPaymentAlloCode.getText();
        temp.setRentPaymentAlloCode(RentPaymentAlloCode.getText());
        RentPaymentAmountReceived.getText();
        temp.setRentPaymentAmountReceived(RentPaymentAmountReceived.getText());
        RentPaymentTenantAccount.getText();
        temp.setRentPaymentTenantAccount(RentPaymentTenantAccount.getText());
        RentPaymentTenantName.getText();
        temp.setRentPaymentTenantName(RentPaymentTenantName.getText());
        RentPaymentPropertyCode.getText();
        temp.setRentPaymentPropertyCode(RentPaymentPropertyCode.getText());
        RentPaymentPropertyType.getText();
        temp.setRentPaymentPropertyType(RentPaymentPropertyType.getText());
        RentPaymentMonth.getValue();
        RentPaymentYear.getText();
        temp.setRentPaymentFor(RentPaymentMonth.getValue() + " " + RentPaymentYear.getText());
        list.add(temp);
    }

}
