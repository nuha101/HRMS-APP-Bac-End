package com.ironhack.midtermproject.hrms.service.impl;

import com.ironhack.midtermproject.hrms.controller.dto.EmployeeInfoIsAdminDTO;
import com.ironhack.midtermproject.hrms.model.Employee;
import com.ironhack.midtermproject.hrms.repository.EmployeeRepository;
import com.ironhack.midtermproject.hrms.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /* -------------- Get employee by id -----------*/
    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id: " + id  + " not found");
        return Optional.of(employeeOptional.get());
    }


    /*----------------- Update employee -----------*/
    @Override
    public void updateEmployee(Employee employee, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id: " + id  + " not found");
        employee.setId(employeeOptional.get().getId());
        employeeRepository.save(employee);

    }


    /* ---------- Update Employee isAdmin ------------*/
    public void updateEmployeeInfoIsAdmin(EmployeeInfoIsAdminDTO employeeInfoIsAdmindto, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id: " + id  + " not found");;
        Employee employee = employeeOptional.get();
        employee.getEmployeeInfo().setAdmin(employeeInfoIsAdmindto.getIsAdmin());
        employeeRepository.save(employee);
    }

    /*------------- Delete employee ------------*/
    @Override
    public void deleteEmployee(Integer id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id: " + id  + " not found");;
        Employee employee = employeeOptional.get();
        employeeRepository.delete(employee);
    }

}
