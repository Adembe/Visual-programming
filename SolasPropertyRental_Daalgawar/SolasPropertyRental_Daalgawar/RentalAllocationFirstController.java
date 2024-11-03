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
import java.time.LocalDate;
import java.util.Locale;

public class RentalAllocationFirstController {
    @FXML
    private TableView<RentalAllocations> TableViewRentAllocations;

    public static ObservableList<RentalAllocations> list1 = FXCollections.observableArrayList();
    @FXML
    private TableColumn<RentalAllocations, String> colAllocationCode;

    @FXML
    private TableColumn<RentalAllocations, String> colContractLength;

    @FXML
    private TableColumn<RentalAllocations, LocalDate> colDateAllocated;

    @FXML
    private TableColumn<RentalAllocations, String> colMonthlyRent;

    @FXML
    private TableColumn<RentalAllocations, String> colPropertyCode;

    @FXML
    private TableColumn<RentalAllocations, String> colPropertyType;

    @FXML
    private TableColumn<RentalAllocations, LocalDate> colRentStartDate;

    @FXML
    private TableColumn<RentalAllocations, String> colTenantAccount;

    @FXML
    private TableColumn<RentalAllocations, String> colTenantName;
    @FXML
    private Button btnAllocationClose;

    @FXML
    private Button btnNewRentalAllocation;

    @FXML
    void initialize(){
        colAllocationCode.setCellValueFactory(new PropertyValueFactory<>("RentAllocationCode"));
        colDateAllocated.setCellValueFactory(new PropertyValueFactory<>("RentAllocationDateRec"));
        colTenantAccount.setCellValueFactory(new PropertyValueFactory<>("RentAllocationAccount"));
        colTenantName.setCellValueFactory(new PropertyValueFactory<>("RentAllocationTenantName"));
        colPropertyCode.setCellValueFactory(new PropertyValueFactory<>("RentAllocationPropertyCode"));
        colPropertyType.setCellValueFactory(new PropertyValueFactory<>("RentAllocationPropertyType"));
        colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("RentAllocationMonthlyRent"));
        colContractLength.setCellValueFactory(new PropertyValueFactory<>("AllocationComboBox"));
        colRentStartDate.setCellValueFactory(new PropertyValueFactory<>("RentAllocationRentStartDate"));
        TableViewRentAllocations.setItems(list1);
    }
    @FXML
    void AllocationClose(ActionEvent event) {
        Stage stage  = (Stage) btnAllocationClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void NewRentalAllocation(ActionEvent event) throws IOException {
        Stage newrent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RentalAllocations.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 380);
        newrent.setTitle("Solas Property Rental- Rental Allocation");
        newrent.setScene(scene);
        newrent.show();
    }
}
