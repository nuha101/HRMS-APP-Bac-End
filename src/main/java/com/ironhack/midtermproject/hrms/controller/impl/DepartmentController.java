package com.ironhack.midtermproject.hrms.controller.impl;

import com.ironhack.midtermproject.hrms.controller.dto.DepartmentManagerDTO;
import com.ironhack.midtermproject.hrms.controller.interfaces.IDepartmentController;
import com.ironhack.midtermproject.hrms.model.Department;
import com.ironhack.midtermproject.hrms.model.Employee;
import com.ironhack.midtermproject.hrms.repository.DepartmentRepository;
import com.ironhack.midtermproject.hrms.service.impl.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hrms")
public class DepartmentController implements IDepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;


    /* ----------------------------------- GET REQUESTS ------------------------------------*/


    /* -------- All Department -------- */
    @GetMapping("/departments")
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    /*-------- department By Id -------*/
    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Integer id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) return null;
        return Optional.of(departmentOptional.get());
    }


    /* ---------------------------------- POST REQUESTS ----------------------------------*/


    /*------------ Add department ----------*/
    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public void postDepartment (@RequestBody Department department){
        departmentRepository.save(department);
    }

    /* ----- Update Department's manager -----*/
    @PatchMapping("/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartmentManager(@RequestBody DepartmentManagerDTO departmentManagerDTO, @PathVariable Integer id) {
        departmentService.updateDepartmentManager(departmentManagerDTO, id);
    }


}
