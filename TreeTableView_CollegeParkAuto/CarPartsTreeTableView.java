package com.example.daalgawruud;

import javafx.beans.property.*;

public class CarPartsTreeTableView {
    public StringProperty yr;
    public StringProperty mk;
    public StringProperty mdl;
    public StringProperty cat;

    public CarPartsTreeTableView() {
    }

    public CarPartsTreeTableView(String year, String make, String model, String type) {
        yr = new SimpleStringProperty(year);
        mk = new SimpleStringProperty(make);
        mdl = new SimpleStringProperty(model);
        cat = new SimpleStringProperty(type);
    }

    public String getYr() {
        return yr.get();
    }

    public StringProperty yrProperty() {
        return yr;
    }

    public String getMk() {
        return mk.get();
    }

    public StringProperty mkProperty() {
        return mk;
    }

    public String getMdl() {
        return mdl.get();
    }

    public StringProperty mdlProperty() {
        return mdl;
    }

    public String getCat() {
        return cat.get();
    }

    public StringProperty catProperty() {
        return cat;
    }

    public void setYr(String yr) {
        this.yr.set(yr);
    }

    public void setMk(String mk) {
        this.mk.set(mk);
    }

    public void setMdl(String mdl) {
        this.mdl.set(mdl);
    }

    public void setCat(String cat) {
        this.cat.set(cat);
    }
}
