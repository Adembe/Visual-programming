package com.example.lab8_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class modelEditorController {
    private Stage modelEdit;
    private partEditorController partEditCont;
    private String modelResult = null;

    @FXML
    private TextField txtModel;

    public void setModelEdit(Stage modelEdit) {
        this.modelEdit = modelEdit;
    }

    public void setPartEditCont(partEditorController partEditCont) {
        this.partEditCont = partEditCont;
    }

    @FXML
    void close(ActionEvent event) {
        modelEdit.close();
    }

    @FXML
    public String getModelResult() {
        return modelResult;
    }

    public void setModelCombo() {
        modelResult = txtModel.getText();
        txtModel.getScene().getWindow().hide();
    }

}
