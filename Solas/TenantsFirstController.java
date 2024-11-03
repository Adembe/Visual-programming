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

public class TenantsFirstController {
    public static ObservableList<Tenant> list2 = FXCollections.observableArrayList();
    @FXML
    private TableView<Tenant> TableViewTenant;

    @FXML
    private Button btnNewTenants;

    @FXML
    private Button btnTenantsClose;

    @FXML
    private TableColumn<Tenant, String> colAccountNumber;

    @FXML
    private TableColumn<Tenant, String> colFullName;

    @FXML
    private TableColumn<Tenant, String> colMaritalStatus;

    @FXML
    private TableColumn<Tenant, String> colPhoneNumber;

    @FXML
    void initialize(){
        colAccountNumber.setCellValueFactory(new PropertyValueFactory<>("TenantsAccount"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("TenantsFullName"));
        colMaritalStatus.setCellValueFactory(new PropertyValueFactory<>("TenantsMartialStatus"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("TenantsPhone"));
        TableViewTenant.setItems(list2);
    }
    @FXML
    void NewTenants(ActionEvent event) throws IOException {
        Stage rent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tenants.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        rent.setTitle("Solas Property Rental- Tenant Editor");
        rent.setScene(scene);
        rent.show();
    }

    @FXML
    void TenantsClose(ActionEvent event) {
        Stage stage  = (Stage) btnTenantsClose.getScene().getWindow();
        stage.close();
    }
}
