package com.ironhack.midtermproject.hrms.service.interfaces;

import com.ironhack.midtermproject.hrms.controller.dto.DepartmentManagerDTO;

public interface IDepartmentService {
    void updateDepartmentManager(DepartmentManagerDTO departmentManagerDTO, Integer id);
}
