package com.example.lab8_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class partEditorController implements Initializable {
    private Stage partEditor;
    private HelloController mainCont;
    private makeEditorController makeEdit;
    private modelEditorController modelEdit;
    private itemCategoryController itemCategory;
    public ObservableList<String> Makelist = FXCollections.observableArrayList("test");
    public ObservableList<String> Modellist = FXCollections.observableArrayList("test");
    public ObservableList<String> Itemlist = FXCollections.observableArrayList("test");


    @FXML
    private ComboBox<String> cbxCategories;
    @FXML
    private ComboBox<String> cbxMakes;
    @FXML
    private ComboBox<String> cbxModels;
    @FXML
    private TextField txtPartName;
    @FXML
    private TextField txtPartNumber;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private TextField txtYear;


    public void setStage(Stage partEditor) {
        this.partEditor = partEditor;
    }

    @FXML
    void close(ActionEvent event) {
        partEditor.close();
    }


    @FXML
    void makeEditorEvent(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("makeEditor.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Stage makeEditStage = new Stage();
            makeEditStage.setTitle("Make Editor");
            makeEditStage.initModality(Modality.WINDOW_MODAL);
            makeEditStage.initOwner(partEditor);
            Scene scene = new Scene(page);
            makeEditStage.setScene(scene);
            makeEdit = fxmlLoader.getController();
            makeEdit.setMakeEditSt(makeEditStage);
            makeEdit.setPartEditCont(this);
            makeEditStage.showAndWait();

            String result = fxmlLoader.<makeEditorController>getController().getResult();
            Makelist.add(result);

        }catch (Exception ex) {
            System.out.println(" error: " + ex);
        }
    }


    @FXML
    void modelEditorEvent(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modelEditor.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Stage modelEditStage = new Stage();
            modelEditStage.setTitle("Model Editor");
            modelEditStage.initModality(Modality.WINDOW_MODAL);
            modelEditStage.initOwner(partEditor);
            Scene scene = new Scene(page);
            modelEditStage.setScene(scene);
            modelEdit = fxmlLoader.getController();
            modelEdit.setModelEdit(modelEditStage);
            modelEdit.setPartEditCont(this);
            modelEditStage.showAndWait();

            String modelResult = fxmlLoader.<modelEditorController>getController().getModelResult();
            Modellist.add(modelResult);

        }catch (Exception ex) {
            System.out.println(" error: " + ex);
        }
    }

    public void setCombo(){
        cbxMakes.setItems(Makelist);

    }

    public void setModelCombo(){
        cbxModels.setItems(Modellist);
    }

    public void setItemCategoryCombo(){
        cbxCategories.setItems(Itemlist);
    }

    @FXML
    void itemCategoryEvent(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itemCategory.fxml"));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Stage itemCategoryStage = new Stage();
            itemCategoryStage.setTitle("Item Category");
            itemCategoryStage.initModality(Modality.WINDOW_MODAL);
            itemCategoryStage.initOwner(partEditor);
            Scene scene = new Scene(page);
            itemCategoryStage.setScene(scene);
            itemCategory = fxmlLoader.getController();
            itemCategory.setItemCategory(itemCategoryStage);
            itemCategory.setPartEditCont(this);
            itemCategoryStage.showAndWait();

            String itemResult = fxmlLoader.<itemCategoryController>getController().getItemResult();
            Itemlist.add(itemResult);

        }catch (Exception ex) {
            System.out.println(" error: " + ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombo();
        setModelCombo();
        setItemCategoryCombo();
    }

    @FXML
    void btnSubmitEvent(ActionEvent event) {
        Parts part = new Parts(Integer.parseInt(txtYear.getText()),  cbxMakes.getValue(), cbxModels.getValue(), cbxCategories.getValue(), Float.valueOf(txtUnitPrice.getText()), Integer.parseInt(txtPartNumber.getText()), txtPartName.getText());;
//        mainCont.getList().add(part);

        System.out.println(part);
        partEditor.close();
    }

}
