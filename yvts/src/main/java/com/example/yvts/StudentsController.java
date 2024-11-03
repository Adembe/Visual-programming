package com.example.yvts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private Button computeBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button firstBtn;

    @FXML
    private TextField textFirstName;

    @FXML
    private Button lastBtn;

    @FXML
    private TextField textLastName;

    @FXML
    private Button loadBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField prelimGrade;

    @FXML
    private TextField remarks;

    @FXML
    private TableView<Student> resultsTable;

    @FXML
    private TableColumn<Student, String> FirstName;

    @FXML
    private TableColumn<Student, String> LastName;

    @FXML
    private TableColumn<Student, String> StudentID;


    @FXML
    private Button saveBtn;

    @FXML
    private TextField score1;

    @FXML
    private TextField score10;

    @FXML
    private TextField score11;

    @FXML
    private TextField score12;

    @FXML
    private TextField score13;

    @FXML
    private TextField score14;

    @FXML
    private TextField score15;

    @FXML
    private TextField score2;

    @FXML
    private TextField score3;

    @FXML
    private TextField score4;

    @FXML
    private TextField score5;

    @FXML
    private TextField score6;

    @FXML
    private TextField score7;

    @FXML
    private TextField score8;

    @FXML
    private TextField score9;

    @FXML
    private Button showBtn;

    @FXML
    private TextField textStudentID;

    @FXML
    private Button updateBtn;


    @FXML
    void clearAll() {
        score1.clear();
        score2.clear();
        score3.clear();
        score4.clear();
        score5.clear();
        score6.clear();
        score7.clear();
        score8.clear();
        score9.clear();
        score10.clear();
        score11.clear();
        score12.clear();
        score13.clear();
        score14.clear();
        score15.clear();
        prelimGrade.clear();
        remarks.clear();
    }


    @FXML
    void computeGrades(ActionEvent event2) {
//        int temp;
//        float ten;
//        String str;
//        temp = 5*(Integer.parseInt(score1.getText()));
//        score2.setText(String.format(temp));
//        ten=temp/10;
//        score3.setText(String.format(ten))
//        temp = 2*(Integer.parseInt(score4.getText()));
//        score5.setText(String.format(temp));
//        ten=temp/10;
//        score3.setText(String.format(ten))
//        temp = 2*(Integer.parseInt(score7.getText()));
//        score8.setText(String.format(temp));
//        ten=temp/10;
//        score3.setText(String.format(ten))
//        temp = (Integer.parseInt(score10.getText()));
//        score11.setText(String.format(temp));
//        ten=temp/10;
//        score3.setText(String.format(ten))
//        temp = (Integer.parseInt(score13.getText()));
//        score14.setText(String.format(temp));
//        ten=temp/10;
//        score3.setText(String.format(ten))
    }



    @FXML
    void saveRecord(ActionEvent event) {

    }

    @FXML
    void showDetails(ActionEvent event) {

    }

    @FXML
    void deleteRecord(ActionEvent event) {

    }

    @FXML
    void updateRecord(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void first(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void last(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        resultsTable.setItems(student);
    }

    private ObservableList<Student> student = FXCollections.observableArrayList(
            new Student("1", "Nomin", "Tserenbat"),
            new Student("3", "Nomin", "Tserenbat"),
            new Student("4", "Nomin", "Tserenbat"),
            new Student("5", "Nomin", "Tserenbat"),
            new Student("2", "anungoo", "aaaa")
    );

    @FXML
    void loadGrades(ActionEvent event3) {
        Student student = new Student(textStudentID.getText(), textFirstName.getText(), textLastName.getText());
        resultsTable.getItems().add(student);

    }

}