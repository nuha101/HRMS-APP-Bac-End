package com.ironhack.midtermproject.hrms.repository;

import com.ironhack.midtermproject.hrms.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void findAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        assertEquals(14, employeeList.size());
    }


}