package com.example.lab8_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class makeEditorController implements Initializable {
    private Stage makeEditSt;
    private partEditorController partEditCont;
    private String result = null;

    @FXML
    private TextField txtMake;

    public void setMakeEditSt(Stage makeEditSt) {
        this.makeEditSt = makeEditSt;
    }

    public void setPartEditCont(partEditorController partEditCont) {
        this.partEditCont = partEditCont;
    }

    @FXML
    void close(ActionEvent event) {
        makeEditSt.close();
    }

    @FXML
    public String getResult() {
        return result;
    }

    public void setCombo() {
        result = txtMake.getText();
        txtMake.getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setCombo();
    }
}
