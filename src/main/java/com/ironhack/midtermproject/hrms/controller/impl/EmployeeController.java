package com.ironhack.midtermproject.hrms.controller.impl;
import com.ironhack.midtermproject.hrms.controller.dto.EmployeeInfoIsAdminDTO;
import com.ironhack.midtermproject.hrms.controller.interfaces.IEmployeeController;
import com.ironhack.midtermproject.hrms.model.Employee;
import com.ironhack.midtermproject.hrms.repository.EmployeeRepository;
import com.ironhack.midtermproject.hrms.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hrms")
public class EmployeeController implements IEmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;



    /* ----------------------------- GET REQUESTS -----------------------*/

    /* --- All Employee --- */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    /* --- Employee By Id ---*/
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }


//    @GetMapping("/employees/admin")
//    public List<Employee> getAllEmployeeByEmployeeInfoIsAdminTrue(@RequestParam(defaultValue = "true") boolean admin){
//        return employeeRepository.findAllEmployeeByEmployeeInfoIsAdminTrue(admin);
//    }

    /* --------------------------- POST REQUESTS -----------------------*/

    /* --- Add Employee ---*/
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }



    /* --------------------------- PUT REQUESTS -----------------------*/

    /* --- Update An Employee ---*/
    @PutMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@RequestBody  Employee employee, @PathVariable Integer employeeId){
        employeeService.updateEmployee(employee, employeeId);
    }



    /* --------------------------- PATCH REQUESTS -----------------------*/

    /* --------- update employee is admin -------*/
    @PatchMapping("/employees/isAdmin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeInfoIsAdmin(@RequestBody EmployeeInfoIsAdminDTO employeeInfoIsAdmindto, @PathVariable Integer id){
        employeeService.updateEmployeeInfoIsAdmin(employeeInfoIsAdmindto, id);
    }


    /*----------------------- DELETE REQUESTS -------------------------*/

    /*----------- del employee ------------*/
    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }


}
