package com.ironhack.midtermproject.hrms.service.interfaces;

import com.ironhack.midtermproject.hrms.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface IEmployeeService {

    public Optional<Employee> getEmployeeById( Integer employeeId);

    void updateEmployee(Employee employee, Integer id);

    /*------------- Delete employee ------------*/
    void deleteEmployee(Integer id);
}
