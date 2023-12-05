package com.ironhack.midtermproject.hrms.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermproject.hrms.model.Company;
import com.ironhack.midtermproject.hrms.model.Department;
import com.ironhack.midtermproject.hrms.model.Employee;
import com.ironhack.midtermproject.hrms.model.EmployeeInfo;
import com.ironhack.midtermproject.hrms.repository.CompanyRepository;
import com.ironhack.midtermproject.hrms.repository.DepartmentRepository;
import com.ironhack.midtermproject.hrms.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Employee employee;


    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Optional<Company> companyOptional = companyRepository.findById(1);
        Optional<Department> departmentOptional = departmentRepository.findById(1);

        employee = new Employee(companyOptional.get(), departmentOptional.get(),new EmployeeInfo("Hani", " Ahmed"));
    }


    @Test
    void getAllEmployees_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hrms/employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ahmed"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Nawaf"));
    }

    @Test
    void getEmployeeById_validId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hrms/employees/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
    }

    @Test
    void getEmployeeById_invalidId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hrms/employees/10"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void addEmployee_validBody() throws Exception {
        String body = objectMapper.writeValueAsString(employee);
        MvcResult mvcResult = mockMvc.perform(post("/hrms/employees").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(employeeRepository.findAll().toString().contains("Hani"));
        employeeRepository.save(employee);
    }

    @Test
    void updateEmployee_validBody() throws Exception {
        employee.setEmployeeInfo(new EmployeeInfo("Sultan", "Fahad"));
        String body = objectMapper.writeValueAsString(employee);
        mockMvc.perform(put("/hrms/employees/31").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        assertTrue(employeeRepository.findAll().toString().contains("Sultan"));
    }

    @Test
    void deleteEmployee_validRequest() throws Exception {
        employeeRepository.save(employee);
        mockMvc.perform(delete("/hrms/employee/32"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(employeeRepository.findAll().toString().contains("32"));
    }


}