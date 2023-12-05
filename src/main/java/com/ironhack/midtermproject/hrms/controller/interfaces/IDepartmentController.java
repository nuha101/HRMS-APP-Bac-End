package com.ironhack.midtermproject.hrms.controller.interfaces;

import com.ironhack.midtermproject.hrms.model.Department;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface IDepartmentController {

    public List<Department> getAllDepartment();
    public Optional<Department> getDepartmentById(Integer id);
}
