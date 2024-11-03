package com.example.lab8_1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private HelloApplication main1 = new HelloApplication();
    public ObservableList<Parts> partsEditorList;
    public ObservableList<Parts> getList() {
        return partsEditorList;
    }

    @FXML
    private TableView<Parts> lvwAutoParts;
    @FXML
    private TableColumn<Parts, Integer> colPartNumber;
    @FXML
    private TableColumn<Parts, String> colPartName;
    @FXML
    private TableColumn<Parts, Float> colUnitPrice;


    @FXML
    private TableView<Parts> lvwSelectedParts;
    @FXML
    private TableColumn<Parts, Integer> colPartNumberSelected;
    @FXML
    private TableColumn<Parts, String> colPartNameSelected;
    @FXML
    private TableColumn<Parts, Integer> colQuantitySelected;
    @FXML
    private TableColumn<Parts, Float> colSubTotalSelected;
    @FXML
    private TableColumn<Parts, Float> colUnitPriceSelected;


    @FXML
    private TreeView tvwAutoParts;


    @FXML
    private TextField txtPartName;
    @FXML
    private TextField txtPartNumber;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtSubTotal;
    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtTaxAmount;
    @FXML
    private TextField txtTaxRate;
    @FXML
    private TextField txtSave;
    @FXML
    private TextField txtPartsTotal;
    @FXML
    private TextField txtOpen;
    @FXML
    private TextField txtOrderTotal;


    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClose;

    @FXML
    void close(ActionEvent event)
    {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toPartEditor(ActionEvent event) {

        main1.partEditor();
    }

    @FXML
    private void insertButton() {
        String query = "INSERT INTO customer_order VALUES("+txtPartNumber.getText()+",'"+txtPartName.getText()+"','"+txtUnitPrice.getText()+"',"+txtQuantity.getText()+","+txtSubTotal.getText()+")";
        executeQuery(query);
        showOrderParts();
    }
    boolean isFieldEmpty(){
        if(txtPartNumber.getText().trim().isEmpty() ||
                txtPartName.getText().trim().isEmpty() ||
                txtUnitPrice.getText().trim().isEmpty() ||
                txtQuantity.getText().trim().isEmpty() ||
                txtSubTotal.getText().trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> partIdent = new TreeItem("College Park Auto-Parts");
        partIdent.setExpanded(true);

        TreeItem<String> itemChild1 = new TreeItem<>("2008");
        TreeItem<String> itemChild2 = new TreeItem<>("2007");
        TreeItem<String> itemChild3 = new TreeItem<>("2006");
        TreeItem<String> itemChild4 = new TreeItem<>("2005");
        TreeItem<String> itemChild5 = new TreeItem<>("2004");
        TreeItem<String> itemChild6 = new TreeItem<>("2003");
        TreeItem<String> itemChild7 = new TreeItem<>("2002");

        partIdent.getChildren().addAll(itemChild1, itemChild2, itemChild3, itemChild4, itemChild5, itemChild6, itemChild7 );
        tvwAutoParts.setRoot(partIdent);


        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (isFieldEmpty() == false) {
                    insertButton();
                    txtPartNumber.setText("");
                    txtPartName.setText("");
                    txtUnitPrice.setText("");
                    txtQuantity.setText("");
                    txtSubTotal.setText("");
                } else {
                    System.out.println("Ugugdluu oruulna uu");
                }
            }
        });

        txtQuantity.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                double num1 = Double.parseDouble(txtQuantity.getText());
                double num2 = Double.parseDouble(txtUnitPrice.getText());
                double sum = num1 * num2;
                txtSubTotal.setText(String.valueOf(sum));

            }
        });

        lvwAutoParts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Parts>() {
            @Override
            public void changed(ObservableValue<? extends Parts> observableValue, Parts oldpart, Parts newpart) {
                if(newpart != null) {
                    txtPartNumber.setText(newpart.getPartNum() + "");
                    txtPartName.setText(newpart.getPartName());
                    txtUnitPrice.setText(String.valueOf(newpart.getUnitPrice()));
                }
            }
        });
        showParts();
        showOrderParts();
    }



    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/park_parts","root","");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public ObservableList<Parts> getPartList(){
        ObservableList<Parts> partList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM available_parts ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Parts parts;
            while(rs.next()) {
                parts = new Parts(rs.getInt("PartNum"),rs.getString("PartName"),rs.getFloat("UnitPrice"));
                partList.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partList;
    }

    public ObservableList<Parts> getOrderPartList(){
        ObservableList<Parts> partList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM customer_order ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Parts parts;
            while(rs.next()) {
                parts = new Parts(rs.getInt("PartNum"),rs.getString("PartName"),rs.getFloat("UnitPrice"), rs.getInt("Quantity"), rs.getFloat("Subtotal"));
                partList.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partList;
    }

    public void showOrderParts() {
        ObservableList<Parts> list = getOrderPartList();
        colPartNumberSelected.setCellValueFactory(new PropertyValueFactory<Parts,Integer>("partNum"));
        colPartNameSelected.setCellValueFactory(new PropertyValueFactory<Parts,String>("partName"));
        colUnitPriceSelected.setCellValueFactory(new PropertyValueFactory<Parts,Float>("unitPrice"));
        colQuantitySelected.setCellValueFactory(new PropertyValueFactory<Parts,Integer>("quantity"));
        colSubTotalSelected.setCellValueFactory(new PropertyValueFactory<Parts,Float>("subTotal"));

        lvwSelectedParts.setItems(list);

    }

    public void showParts() {
        ObservableList<Parts> list = getPartList();
        colPartNumber.setCellValueFactory(new PropertyValueFactory<Parts,Integer>("partNum"));
        colPartName.setCellValueFactory(new PropertyValueFactory<Parts,String>("partName"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<Parts,Float>("unitPrice"));
        lvwAutoParts.setItems(list);
    }

}
