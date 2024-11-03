package com.example.daalgawruud;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TableDialog {
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFavoriteColor(String favoriteColor){
        this.favoriteColor = favoriteColor;
    }
    public void setSport(String sport) {
        this.Sport = sport;
    }

    public void setOfYears(Integer ofYears) {
        this.ofYears = ofYears;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFavoriteColor(){
        return favoriteColor;
    }

    public String getSport() {
        return Sport;
    }

    public Integer getOfYears() {
        return ofYears;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }

        private String firstName;
        private String favoriteColor;
        private String Sport;
        private Integer ofYears;
        private boolean vegetarian;

        public TableDialog(String firstName, String fColor, String sports, Integer years, boolean vegetarian) {
            this.firstName = firstName;
            this.favoriteColor = fColor;
            this.Sport = sports;
            this.ofYears = years;
            this.vegetarian = vegetarian;
        }


}

