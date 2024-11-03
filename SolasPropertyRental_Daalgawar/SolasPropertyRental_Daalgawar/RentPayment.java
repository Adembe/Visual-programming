package com.example.daalgawruud;

import javafx.scene.control.ComboBox;

import java.time.LocalDate;

public class RentPayment {
    public RentPayment(String rentPaymentAlloCode, String rentPaymentAmountReceived, LocalDate rentPaymentDateRec, String rentPaymentPropertyType, String rentPaymentPropertyCode, String rentPaymentReceipt, String rentPaymentTenantAccount, String rentPaymentTenantName, String rentPaymentFor) {
        RentPaymentAlloCode = rentPaymentAlloCode;
        RentPaymentAmountReceived = rentPaymentAmountReceived;
        RentPaymentDateRec = rentPaymentDateRec;
        RentPaymentPropertyType = rentPaymentPropertyType;
        RentPaymentPropertyCode = rentPaymentPropertyCode;
        RentPaymentReceipt = rentPaymentReceipt;
        RentPaymentTenantAccount = rentPaymentTenantAccount;
        RentPaymentTenantName = rentPaymentTenantName;
        RentPaymentFor = rentPaymentFor;
    }

    public RentPayment() {
    }

    public String getRentPaymentAlloCode() {
        return RentPaymentAlloCode;
    }

    public String getRentPaymentAmountReceived() {
        return RentPaymentAmountReceived;
    }

    public LocalDate getRentPaymentDateRec() {
        return RentPaymentDateRec;
    }

    public String getRentPaymentPropertyType() {
        return RentPaymentPropertyType;
    }

    public String getRentPaymentPropertyCode() {
        return RentPaymentPropertyCode;
    }

    public String getRentPaymentReceipt() {
        return RentPaymentReceipt;
    }

    public String getRentPaymentTenantAccount() {
        return RentPaymentTenantAccount;
    }

    public String getRentPaymentTenantName() {
        return RentPaymentTenantName;
    }

    public String getRentPaymentFor() {
        return RentPaymentFor;
    }


    public void setRentPaymentAlloCode(String rentPaymentAlloCode) {
        RentPaymentAlloCode = rentPaymentAlloCode;
    }

    public void setRentPaymentAmountReceived(String rentPaymentAmountReceived) {
        RentPaymentAmountReceived = rentPaymentAmountReceived;
    }

    public void setRentPaymentDateRec(LocalDate rentPaymentDateRec) {
        RentPaymentDateRec = rentPaymentDateRec;
    }
    public void setRentPaymentPropertyType(String rentPaymentPropertyType) {
        RentPaymentPropertyType = rentPaymentPropertyType;
    }

    public void setRentPaymentPropertyCode(String rentPaymentPropertyCode) {
        RentPaymentPropertyCode = rentPaymentPropertyCode;
    }

    public void setRentPaymentReceipt(String rentPaymentReceipt) {
        RentPaymentReceipt = rentPaymentReceipt;
    }

    public void setRentPaymentTenantAccount(String rentPaymentTenantAccount) {
        RentPaymentTenantAccount = rentPaymentTenantAccount;
    }

    public void setRentPaymentTenantName(String rentPaymentTenantName) {
        RentPaymentTenantName = rentPaymentTenantName;
    }


    public void setRentPaymentFor(String rentPaymentFor) {
        RentPaymentFor = rentPaymentFor;
    }

    private String RentPaymentAlloCode;
    private String RentPaymentAmountReceived;
    private LocalDate RentPaymentDateRec;
    private String RentPaymentPropertyType;
    private String RentPaymentPropertyCode;
    private String RentPaymentReceipt;
    private String RentPaymentTenantAccount;
    private String RentPaymentTenantName;
    private  String RentPaymentFor;
}
