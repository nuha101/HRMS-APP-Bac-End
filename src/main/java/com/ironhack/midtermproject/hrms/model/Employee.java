package com.ironhack.midtermproject.hrms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
//    @JsonIgnore
    private Company company;
    @ManyToOne
    @JoinColumn(name = "department_id")
//    @JsonIgnore
    private Department department;

    @Embedded
    private EmployeeInfo employeeInfo = new EmployeeInfo();

    public Employee(Company company, Department department, EmployeeInfo employeeInfo) {
        this.company = company;
        this.department = department;
        this.employeeInfo = employeeInfo;
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", EmployeeInfo='" + employeeInfo.toString() + '\'' +
                '}' ;
    }
}
