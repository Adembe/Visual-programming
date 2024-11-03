package com.example.daalgawruud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class RentalAllocations {
    public RentalAllocations(String allocationComboBox, String rentAllocationAccount, String rentAllocationCode, LocalDate rentAllocationDateRec, String rentAllocationMarital, String rentAllocationMonthlyRent, String rentAllocationPropertyCode, String rentAllocationPropertyType, LocalDate rentAllocationRentStartDate, String rentAllocationTenantName) {
        AllocationComboBox = allocationComboBox;
        RentAllocationAccount = rentAllocationAccount;
        RentAllocationCode = rentAllocationCode;
        RentAllocationDateRec = rentAllocationDateRec;
        RentAllocationMarital = rentAllocationMarital;
        RentAllocationMonthlyRent = rentAllocationMonthlyRent;
        RentAllocationPropertyCode = rentAllocationPropertyCode;
        RentAllocationPropertyType = rentAllocationPropertyType;
        RentAllocationRentStartDate = rentAllocationRentStartDate;
        RentAllocationTenantName = rentAllocationTenantName;
    }

    public RentalAllocations() {
    }

    public String getAllocationComboBox() {
        return AllocationComboBox;
    }

    public String getRentAllocationAccount() {
        return RentAllocationAccount;
    }

    public String getRentAllocationCode() {
        return RentAllocationCode;
    }

    public LocalDate getRentAllocationDateRec() {
        return RentAllocationDateRec;
    }

    public String getRentAllocationMarital() {
        return RentAllocationMarital;
    }

    public String getRentAllocationMonthlyRent() {
        return RentAllocationMonthlyRent;
    }

    public String getRentAllocationPropertyCode() {
        return RentAllocationPropertyCode;
    }

    public String getRentAllocationPropertyType() {
        return RentAllocationPropertyType;
    }

    public LocalDate getRentAllocationRentStartDate() {
        return RentAllocationRentStartDate;
    }

    public String getRentAllocationTenantName() {
        return RentAllocationTenantName;
    }

    public void setAllocationComboBox(String allocationComboBox) {
        AllocationComboBox = allocationComboBox;
    }

    public void setRentAllocationAccount(String rentAllocationAccount) {
        RentAllocationAccount = rentAllocationAccount;
    }

    public void setRentAllocationCode(String rentAllocationCode) {
        RentAllocationCode = rentAllocationCode;
    }

    public void setRentAllocationDateRec(LocalDate rentAllocationDateRec) {
        RentAllocationDateRec = rentAllocationDateRec;
    }

    public void setRentAllocationMarital(String rentAllocationMarital) {
        RentAllocationMarital = rentAllocationMarital;
    }

    public void setRentAllocationMonthlyRent(String rentAllocationMonthlyRent) {
        RentAllocationMonthlyRent = rentAllocationMonthlyRent;
    }

    public void setRentAllocationPropertyCode(String rentAllocationPropertyCode) {
        RentAllocationPropertyCode = rentAllocationPropertyCode;
    }

    public void setRentAllocationPropertyType(String rentAllocationPropertyType) {
        RentAllocationPropertyType = rentAllocationPropertyType;
    }

    public void setRentAllocationRentStartDate(LocalDate rentAllocationRentStartDate) {
        RentAllocationRentStartDate = rentAllocationRentStartDate;
    }

    public void setRentAllocationTenantName(String rentAllocationTenantName) {
        RentAllocationTenantName = rentAllocationTenantName;
    }

    private String AllocationComboBox;
    private String RentAllocationAccount;
    private String RentAllocationCode;
    private LocalDate RentAllocationDateRec;
    private String RentAllocationMarital;
    private String RentAllocationMonthlyRent;
    private String RentAllocationPropertyCode;
    private String RentAllocationPropertyType;
    private LocalDate RentAllocationRentStartDate;
    private String RentAllocationTenantName;
}
