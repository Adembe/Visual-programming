package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.daalgawruud.TenantsFirstController.list2;

public class TenantController {
    @FXML
    private TextField TenantsAccount;

    @FXML
    private TextField TenantsFullName;

    @FXML
    private ComboBox<String> TenantsMartialStatus;

    @FXML
    private TextField TenantsPhone;

    @FXML
    private Button btnTenantCancel;

    @FXML
    private Button btnTenantOk;
    @FXML
    ObservableList<String> tenantList = FXCollections.observableArrayList("Single",
            "Widow",
            "Married",
            "Divorced",
            "Separated");


    @FXML
    void initialize(){
        TenantsMartialStatus.setItems(tenantList);
    }
    @FXML
    void TenantCancel(ActionEvent event) {
        Stage stage  = (Stage) btnTenantCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void TenantOk(ActionEvent event) {
        Tenant obj = new Tenant();
        TenantsAccount.getText();
        obj.setTenantsAccount(TenantsAccount.getText());
        TenantsFullName.getText();
        obj.setTenantsFullName(TenantsFullName.getText());
        TenantsMartialStatus.getValue();
        obj.setTenantsMartialStatus(TenantsMartialStatus.getValue());
        TenantsPhone.getText();
        obj.setTenantsPhone(TenantsPhone.getText());
        list2.add(obj);
    }
}
