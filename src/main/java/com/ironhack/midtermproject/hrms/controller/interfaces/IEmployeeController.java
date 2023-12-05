package com.ironhack.midtermproject.hrms.controller.interfaces;

import com.ironhack.midtermproject.hrms.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IEmployeeController {

    public List<Employee> getAllEmployees();

    public Optional<Employee> getEmployeeById(Integer employeeId);
//    public List<Employee> getAllEmployeeByEmployeeInfoIsAdminTrue(boolean isAdmin );


}
