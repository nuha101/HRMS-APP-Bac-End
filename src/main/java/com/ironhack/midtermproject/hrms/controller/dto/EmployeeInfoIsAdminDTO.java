package com.ironhack.midtermproject.hrms.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeInfoIsAdminDTO {

    private boolean isAdmin;

    public EmployeeInfoIsAdminDTO() {
    }

    @JsonProperty("isAdmin")
    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    @JsonProperty("isAdmin")
    public void setIsAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return "EmployeeInfoIsAdminDTO{" +
                "admin=" + this.isAdmin +
                '}';
    }
}
