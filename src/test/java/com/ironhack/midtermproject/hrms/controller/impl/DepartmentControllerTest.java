package com.ironhack.midtermproject.hrms.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermproject.hrms.controller.dto.DepartmentManagerDTO;
import com.ironhack.midtermproject.hrms.model.*;
import com.ironhack.midtermproject.hrms.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DepartmentControllerTest {

    @Autowired
    DepartmentRepository departmentRepository;


    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Department department ;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }


    @Test
    void updateDepartmentManager() throws Exception {
        DepartmentManagerDTO departmentManagerDTO = new DepartmentManagerDTO(new Employee(2));

        String body = objectMapper.writeValueAsString(departmentManagerDTO);
        mockMvc.perform(patch("/hrms/department/1").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        assertTrue(departmentRepository.findAll().toString().contains("2"));

    }
}