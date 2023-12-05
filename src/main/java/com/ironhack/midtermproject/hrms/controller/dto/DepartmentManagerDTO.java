package com.ironhack.midtermproject.hrms.controller.dto;

import com.ironhack.midtermproject.hrms.model.Employee;

public class DepartmentManagerDTO {

    private Employee manager;

    public DepartmentManagerDTO() {
    }

    public DepartmentManagerDTO(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }


}
