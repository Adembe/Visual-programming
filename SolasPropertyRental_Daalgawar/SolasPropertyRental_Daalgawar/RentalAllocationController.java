package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.daalgawruud.RentalAllocationFirstController.list1;


public class RentalAllocationController {
    @FXML
    private ComboBox<String> AllocationComboBox;
    @FXML
    ObservableList<String> comboList = FXCollections.observableArrayList("3 Months",
            "6 Months",
            "12 Months");

    @FXML
    private TextField RentAllocationAccount;

    @FXML
    private TextField RentAllocationCode;

    @FXML
    private DatePicker RentAllocationDateRec;

    @FXML
    private TextField RentAllocationMarital;

    @FXML
    private TextField RentAllocationMonthlyRent;

    @FXML
    private TextField RentAllocationPropertyCode;

    @FXML
    private TextField RentAllocationPropertyType;

    @FXML
    private DatePicker RentAllocationRentStartDate;

    @FXML
    private TextField RentAllocationTenantName;

    @FXML
    private Button btnAllocationCancel;
    @FXML
    private Button btnAllocationOK;
    @FXML
    void initialize(){
        AllocationComboBox.setItems(comboList);
    }
    @FXML
    void AllocationCancel(ActionEvent event) {
        Stage stage  = (Stage) btnAllocationCancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    void AllocationOK(ActionEvent event) {
        RentalAllocations obj = new RentalAllocations();
        RentAllocationCode.getText();
        obj.setRentAllocationCode(RentAllocationCode.getText());
        RentAllocationDateRec.getValue();
        obj.setRentAllocationDateRec(RentAllocationDateRec.getValue());
        RentAllocationAccount.getText();
        obj.setRentAllocationAccount(RentAllocationAccount.getText());
        RentAllocationTenantName.getText();
        obj.setRentAllocationTenantName(RentAllocationTenantName.getText());
        RentAllocationMarital.getText();
        obj.setRentAllocationMarital(RentAllocationMarital.getText());
        RentAllocationPropertyCode.getText();
        obj.setRentAllocationPropertyCode(RentAllocationPropertyCode.getText());
        RentAllocationPropertyType.getText();
        obj.setRentAllocationPropertyType(RentAllocationPropertyType.getText());
        RentAllocationMonthlyRent.getText();
        obj.setRentAllocationMonthlyRent(RentAllocationMonthlyRent.getText());
        AllocationComboBox.getValue();
        obj.setAllocationComboBox(AllocationComboBox.getValue());
        RentAllocationRentStartDate.getValue();
        obj.setRentAllocationRentStartDate(RentAllocationRentStartDate.getValue());
        list1.add(obj);
    }
}
