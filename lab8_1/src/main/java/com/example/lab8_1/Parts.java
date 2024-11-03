package com.example.lab8_1;

import javafx.beans.property.*;

public class Parts {
    private  IntegerProperty partNum;
    private  StringProperty partName;
    private  FloatProperty unitPrice;
    private IntegerProperty quantity;
    private FloatProperty subTotal;

    private IntegerProperty year;
    private StringProperty make;
    private StringProperty model;
    private StringProperty category;


    public Parts(Integer  PartNum, String  PartName, float  UnitPrice, Integer Quantity, float Subtotal){
        this.partNum = new SimpleIntegerProperty(PartNum);
        this.partName=new SimpleStringProperty(PartName);
        this.unitPrice = new SimpleFloatProperty(UnitPrice);
        this.quantity = new SimpleIntegerProperty(Quantity);
        this.subTotal = new SimpleFloatProperty(Subtotal);
    }

    public Parts(int partNum, String partName, float unitPrice) {
        this.partNum = new SimpleIntegerProperty(partNum);
        this.partName=new SimpleStringProperty(partName);
        this.unitPrice = new SimpleFloatProperty(unitPrice);
    }

    public Parts(int year, String make, String model, String category, float unitPrice, int partNum, String partName) {
        this.year = new SimpleIntegerProperty(year);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.category = new SimpleStringProperty(category);
        this.unitPrice = new SimpleFloatProperty(unitPrice);
        this.partNum = new SimpleIntegerProperty(partNum);
        this.partName=new SimpleStringProperty(partName);

    }

    public IntegerProperty partNumProperty() {
        return partNum;
    }
    public Integer getPartNum() {
        return partNum.get();
    }

    public void setPartNum() {
        this.partNum = partNum;
    }

    public StringProperty getPartNameProperty() {
        return partName;
    }
    public String getPartName() {
        return partName.get();
    }

    public FloatProperty getUnitPriceProperty() {
        return unitPrice;
    }
    public Float getUnitPrice() {
        return unitPrice.get();
    }

    public void setUnitPrice() {
        this.unitPrice = unitPrice;
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
    public Integer getQuantity() {
        return quantity.get();
    }

    public void setQuantity(IntegerProperty quantity) {
        this.quantity = quantity;
    }

    public FloatProperty getSubTotalProperty() {
        return subTotal;
    }
    public Float getSubTotal() {
        return subTotal.get();
    }

    public void setSubTotal() {
        this.subTotal = subTotal;
    }
    @Override
    public String toString(){
        return partNum.get() + " " + partName.get() + " "+ unitPrice.get();
    }
}
