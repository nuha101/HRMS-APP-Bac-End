package com.ironhack.midtermproject.hrms.service.impl;

import com.ironhack.midtermproject.hrms.controller.dto.DepartmentManagerDTO;
import com.ironhack.midtermproject.hrms.model.Department;
import com.ironhack.midtermproject.hrms.repository.DepartmentRepository;
import com.ironhack.midtermproject.hrms.service.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    /* ----------- Update department manager --------------*/

    @Override
    public void updateDepartmentManager(DepartmentManagerDTO departmentManagerDTO, Integer id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with id: " + id + " not found" );
        Department department = departmentOptional.get();
        department.setManager(departmentManagerDTO.getManager());
        departmentRepository.save(department);
    }
}
