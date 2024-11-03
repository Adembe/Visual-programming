package com.example.daalgawruud;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Tenant {
    public Tenant(String tenantsAccount, String tenantsFullName, String tenantsMartialStatus, String tenantsPhone) {
        TenantsAccount = tenantsAccount;
        TenantsFullName = tenantsFullName;
        TenantsMartialStatus = tenantsMartialStatus;
        TenantsPhone = tenantsPhone;
    }

    public Tenant() {
    }

    public String getTenantsAccount() {
        return TenantsAccount;
    }

    public String getTenantsFullName() {
        return TenantsFullName;
    }

    public String getTenantsMartialStatus() {
        return TenantsMartialStatus;
    }

    public String getTenantsPhone() {
        return TenantsPhone;
    }

    public void setTenantsAccount(String tenantsAccount) {
        TenantsAccount = tenantsAccount;
    }

    public void setTenantsFullName(String tenantsFullName) {
        TenantsFullName = tenantsFullName;
    }

    public void setTenantsMartialStatus(String tenantsMartialStatus) {
        TenantsMartialStatus = tenantsMartialStatus;
    }

    public void setTenantsPhone(String tenantsPhone) {
        TenantsPhone = tenantsPhone;
    }

    private String TenantsAccount;
    private String TenantsFullName;
    private String TenantsMartialStatus;
    private String TenantsPhone;

}
