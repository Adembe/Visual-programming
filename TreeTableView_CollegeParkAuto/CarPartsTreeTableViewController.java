package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class CarPartsTreeTableViewController {
    @FXML
    private TreeTableColumn<CarPartsTreeTableView, String> colMake;

    @FXML
    private TreeTableColumn<CarPartsTreeTableView, String> colModel;

    @FXML
    private TreeTableColumn<CarPartsTreeTableView, String> colType;

    @FXML
    private TreeTableColumn<CarPartsTreeTableView, String> colYears;

    @FXML
    private TreeTableView<CarPartsTreeTableView> treeTableView;

    CarPartsTreeTableView obj;
    ObservableList<TreeItem<String>> items;
    ArrayList<CarPartsTreeTableView> parts;
    ArrayList<String> years = new ArrayList<>();
    TreeItem<CarPartsTreeTableView> rootItem;

    Image home = new Image(Objects.requireNonNull(getClass().getResourceAsStream("home.png")));


    @FXML
    void initialize(){
        obj = new CarPartsTreeTableView("College Park Auto-Parts","","","");
        colYears.setCellValueFactory(new TreeItemPropertyValueFactory<CarPartsTreeTableView, String>("yr"));
        colMake.setCellValueFactory(new TreeItemPropertyValueFactory<CarPartsTreeTableView, String>("mk"));
        colModel.setCellValueFactory(new TreeItemPropertyValueFactory<CarPartsTreeTableView, String>("mdl"));
        colType.setCellValueFactory(new TreeItemPropertyValueFactory<CarPartsTreeTableView, String>("cat"));
        buildData();
        addNodes();
    }

    void addNodes(){
        TreeItem<CarPartsTreeTableView> rootNode = new TreeItem<>(obj, new ImageView(home));
        for(CarPartsTreeTableView p : parts){
            if(!years.contains(p.getYr())) {
                rootItem = new TreeItem<>(new CarPartsTreeTableView(p.getYr(),"","",""));
                years.add(p.getYr());
                rootNode.getChildren().add(rootItem);
                rootItem.getChildren().add(new TreeItem<>(p));
            }   else {
                rootItem.getChildren().add(new TreeItem<>(p));
            }
        }
        treeTableView.setRoot(rootNode);
    }
    void buildData(){
        parts = new ArrayList<>();
        parts.add(new CarPartsTreeTableView("2002", "Ford",
                "Escort SE L4 2.0", "Engine Electrical"));
        parts.add(new CarPartsTreeTableView("2006", "Dodge",
                "Caravan SE L4 2.4", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2002", "Honda",
                "Civic 1.7 EX 4DR", "Exhaust"));
        parts.add(new CarPartsTreeTableView("1996", "Buick",
                "Regal Custom V6 3.8", "Fuel Injection"));
        parts.add(new CarPartsTreeTableView("2004", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add(new CarPartsTreeTableView("2001", "Ford",
                "Taurus LX V6 3.0", "Fuel Injection"));
        parts.add(new CarPartsTreeTableView("1999", "Jeep",
                "Wrangler Sahara", "Air Intake"));
        parts.add(new CarPartsTreeTableView("1998", "Honda",
                "Accord 2.3 LX 4DR", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2006", "Kia",
                "Rio 1.6DOHC16V 4-DR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2000", "Honda",
                "Civic 1.6 EX 4DR", "Suspension"));
        parts.add(new CarPartsTreeTableView("2003", "Chevrolet",
                "Monte Carlo LS V6 3.4", "Fuel Injection"));
        parts.add(new CarPartsTreeTableView("2002", "Ford",
                "Focus SE DOHC L4 2.0", "Steering"));
        parts.add(new CarPartsTreeTableView("2004", "Honda",
                "Civic 1.7 EX 4DR", "Climate Control"));
        parts.add(new CarPartsTreeTableView("2007", "Toyota",
                "Corolla", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2005", "Volvo",
                "S40 2.5L T5 AWD", "Fuel Delivery"));
        parts.add(new CarPartsTreeTableView("2002", "Ford",
                "Escape XLS 4WD", "Brake"));
        parts.add(new CarPartsTreeTableView("2006", "BMW",
                "325i", "Climate Control"));
        parts.add(new CarPartsTreeTableView("1996", "Chevrolet",
                "Monte Carlo Z34 V6 3.4", "Fuel Delivery"));
        parts.add(new CarPartsTreeTableView("2010", "Toyota",
                "Camry V6", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2001", "Ford",
                "Escape XLT 4WD", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2003", "Honda",
                "Civic 1.7 EX 4DR", "Brake"));
        parts.add(new CarPartsTreeTableView("2006", "BMW",
                "325i", "Climate Control"));
        parts.add(new CarPartsTreeTableView("2011", "Toyota",
                "Corolla", "Body Electrical"));
        parts.add(new CarPartsTreeTableView("2005", "Ford",
                "Focus ZX3 L4 2.0", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2004", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add(new CarPartsTreeTableView("2004", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add(new CarPartsTreeTableView("2006", "BMW",
                "325i", "Climate Control"));
        parts.add(new CarPartsTreeTableView("2019", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add(new CarPartsTreeTableView("2019", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2019", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add(new CarPartsTreeTableView("2022", "Ford",
                "Taurus LX V6 3.0", "Suspension"));
        parts.add(new CarPartsTreeTableView("2022", "Buick",
                "Lacrosse CXS V6 3.6", "Brake"));
        parts.add(new CarPartsTreeTableView("2022", "Ford",
                "Taurus LX V6 3.0", "Suspension"));
        parts.add(new CarPartsTreeTableView("2005", "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2013", "Buick",
                "Lacrosse CXS V6 3.6", "Brake"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("1999", "Jeep",
                "Wrangler Sahara", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2014", "Toyota",
                "Corolla", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2001", "Ford",
                "Escape XLT 4WD", "Transmission"));
        parts.add(new CarPartsTreeTableView("2015", "Toyota",
                "Corolla", "Body Electrical"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2016", "Toyota",
                "Corolla", "Body Electrical"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2017", "Buick",
                "Lacrosse CXS V6 3.6", "Suspension"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2018", "Buick",
                "Lacrosse CXS V6 3.6", "Suspension"));
        parts.add(new CarPartsTreeTableView("2005", "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical"));
        parts.add(new CarPartsTreeTableView("2019", "Toyota",
                "Corolla", "Body Electrical"));
        parts.add(new CarPartsTreeTableView("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2005", "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical"));
        parts.add(new CarPartsTreeTableView("2020", "Buick",
                "Lacrosse CXS V6 3.6", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2001", "Ford",
                "Escape XLT 4WD", "Air Intake"));
        parts.add(new CarPartsTreeTableView("2021", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add(new CarPartsTreeTableView("2022", "Buick",
                "Lacrosse CXS V6 3.6", "Suspension"));

        parts.sort(new YearComparator());
    }
    static class YearComparator implements Comparator<CarPartsTreeTableView> {

        @Override
        public int compare(CarPartsTreeTableView o1, CarPartsTreeTableView o2) {
            return Integer.parseInt(o2.getYr()) - Integer.parseInt(o1.getYr());
        }
    }
}
