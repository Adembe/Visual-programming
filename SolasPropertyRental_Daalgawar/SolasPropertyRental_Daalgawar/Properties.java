package com.example.daalgawruud;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Properties {
    public String getPropertyBathrooms() {
        return PropertyBathrooms;
    }

    public String getPropertyBedrooms() {
        return PropertyBedrooms;
    }

    public String getPropertyCode() {
        return PropertyCode;
    }

    public String getPropertyMonthlyRent() {
        return PropertyMonthlyRent;
    }

    public String getPropertyOccupancyStatus() {
        return PropertyOccupancyStatus;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    private String PropertyBathrooms;
    private String PropertyBedrooms;
    private String PropertyCode;
    private String PropertyMonthlyRent;
    private String PropertyOccupancyStatus;
    private String PropertyType;

    public Properties(String propertyBathrooms, String propertyBedrooms, String propertyCode, String propertyMonthlyRent, String propertyOccupancyStatus, String propertyType) {
        PropertyBathrooms = propertyBathrooms;
        PropertyBedrooms = propertyBedrooms;
        PropertyCode = propertyCode;
        PropertyMonthlyRent = propertyMonthlyRent;
        PropertyOccupancyStatus = propertyOccupancyStatus;
        PropertyType = propertyType;
    }

    public Properties() {
    }

    public void setPropertyBathrooms(String propertyBathrooms) {
        PropertyBathrooms = propertyBathrooms;
    }

    public void setPropertyBedrooms(String propertyBedrooms) {
        PropertyBedrooms = propertyBedrooms;
    }

    public void setPropertyCode(String propertyCode) {
        PropertyCode = propertyCode;
    }

    public void setPropertyMonthlyRent(String propertyMonthlyRent) {
        PropertyMonthlyRent = propertyMonthlyRent;
    }

    public void setPropertyOccupancyStatus(String propertyOccupancyStatus) {
        PropertyOccupancyStatus = propertyOccupancyStatus;
    }

    public void setPropertyType(String propertyType) {
        PropertyType = propertyType;
    }
}
