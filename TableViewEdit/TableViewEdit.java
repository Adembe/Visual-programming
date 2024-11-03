package com.example.daalgawruud;

import javafx.scene.control.*;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import static javafx.scene.control.cell.ProgressBarTableCell.forTableColumn;

public class TableViewEdit extends Application {
    ObservableList<String> comboBox = FXCollections.observableArrayList("Snowboarding","Rowing","Knitting","Speed reading","Pool");
    @Override
    public void start(Stage stage) {

        TableView<TableDialog> table = new TableView<TableDialog>();

        // EditTable
        table.setEditable(true);
        // TableColumn
        TableColumn<TableDialog, String> firstNameCol = new TableColumn<TableDialog, String>("First Name");
        TableColumn<TableDialog,String> favoriteCol = new TableColumn<TableDialog, String>("Favorite Color");
        TableColumn<TableDialog, String> sportCol = new TableColumn<TableDialog, String>("Sport");
        TableColumn<TableDialog, Integer> ofYearsCol = new TableColumn<TableDialog, Integer>("#ofYears");
        TableColumn<TableDialog, Boolean> vegetarianCol = new TableColumn<TableDialog, Boolean>("Vegetarian");

        // ==== FULL NAME (TEXT FIELD) ===
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<TableDialog> forTableColumn());
        firstNameCol.setMinWidth(100);
        // On Cell edit commit (for FullName column)
        firstNameCol.setOnEditCommit((TableColumn.CellEditEvent<TableDialog, String> e) -> {
            TablePosition<TableDialog, String> pos = e.getTablePosition();
            String newFirstName = e.getNewValue();
            int row = pos.getRow();
            TableDialog object1 = e.getTableView().getItems().get(row);
            object1.setFirstName(newFirstName);
        });

        // ==== Color ===
        favoriteCol.setCellValueFactory(new PropertyValueFactory<>("favoriteColor"));
        favoriteCol.setMinWidth(100);
        favoriteCol.setCellFactory(new Callback<TableColumn<TableDialog,String>,
                                    TableCell<TableDialog,String>>() {
                                @Override
                                public TableCell<TableDialog,String> call(TableColumn<TableDialog,String> list) {
                                    return new ColorRectCell();
                                }
                            }
        );


        // ==== Sport ===
        sportCol.setCellValueFactory(new PropertyValueFactory<>("Sport"));
        sportCol.setCellFactory(ComboBoxTableCell.forTableColumn(comboBox));
        sportCol.setMinWidth(100);
        sportCol.setOnEditCommit((TableColumn.CellEditEvent<TableDialog, String> event) -> {
          TablePosition<TableDialog, String> pos = event.getTablePosition();
          String newSport = event.getNewValue();
          int row = pos.getRow();
          TableDialog object2 = event.getTableView().getItems().get(row);
          object2.setSport(newSport);
        });


        // ==== Years ====
        ofYearsCol.setCellValueFactory(new PropertyValueFactory<>("ofYears"));
        ofYearsCol.setCellFactory(TextFieldTableCell.<TableDialog, Integer> forTableColumn(new IntegerStringConverter()));
        ofYearsCol.setMinWidth(80);


        vegetarianCol.setCellValueFactory(new Callback<CellDataFeatures<TableDialog, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<TableDialog, Boolean> param) {
                TableDialog object3 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(object3.isVegetarian());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        object3.setVegetarian(newValue);
                    }
                });
                return booleanProp;
            }
        });

        vegetarianCol.setCellFactory(new Callback<TableColumn<TableDialog, Boolean>, //
                TableCell<TableDialog, Boolean>>() {
            @Override
            public TableCell<TableDialog, Boolean> call(TableColumn<TableDialog, Boolean> p) {
                CheckBoxTableCell<TableDialog, Boolean> cell = new CheckBoxTableCell<TableDialog, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        vegetarianCol.setMinWidth(100);

        ObservableList<TableDialog> list = getTableDialogList();
        table.setItems(list);

        table.getColumns().addAll(firstNameCol, favoriteCol, sportCol, ofYearsCol,vegetarianCol);
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);
        stage.setTitle("TableView");

        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<TableDialog> getTableDialogList() {

        TableDialog person1 = new TableDialog("Mary","red", "Snowboarding", 5, false);
        TableDialog person2 = new TableDialog("Alison","green", "Rowing",3,true);
        TableDialog person3 = new TableDialog("Kathy","darkgray","Knitting",2,false );

        ObservableList<TableDialog> list = FXCollections.observableArrayList(person1, person2, person3);
        return list;
    }

    static class ColorRectCell extends TableCell<TableDialog,String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web(item));
                Color c = (Color) rect.getFill();
                String hex = ("RGB value: " +    (int)( c.getRed() * 255 )+","+
                        (int)( c.getGreen() * 255 )+","+
                        (int)( c.getBlue() * 255 ) );
                super.setTooltip(new Tooltip(hex));
                setGraphic(rect);


            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}