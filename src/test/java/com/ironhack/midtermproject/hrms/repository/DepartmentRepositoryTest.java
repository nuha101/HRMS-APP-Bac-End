package com.ironhack.midtermproject.hrms.repository;

import com.ironhack.midtermproject.hrms.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void findAllDepartment(){

        List<Department> departmentList = departmentRepository.findAll();
        assertEquals(5, departmentList.size());
    }

    @Test
    public void findDepartmentById(){
        Optional<Department> departmentOptional = departmentRepository.findById(2);
        if(departmentOptional.isEmpty()) return;
        String foundDepartment = departmentOptional.get().getName().toString();
        assertEquals("MARKETING", foundDepartment);

    }
}