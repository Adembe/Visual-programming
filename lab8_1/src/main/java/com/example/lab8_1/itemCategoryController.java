package com.example.lab8_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class itemCategoryController {

    private Stage itemCategory;
    private partEditorController partEditCont;
    private String itemResult = null;

    @FXML
    private TextField txtCategory;


    public void setItemCategory(Stage itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setPartEditCont(partEditorController partEditCont) {
        this.partEditCont = partEditCont;
    }

    @FXML
    void close(ActionEvent event) {
        itemCategory.close();
    }

    @FXML
    public String getItemResult() {
        return itemResult;
    }

    public void setItemCategoryCombo() {
        itemResult = txtCategory.getText();
        txtCategory.getScene().getWindow().hide();
    }
}
