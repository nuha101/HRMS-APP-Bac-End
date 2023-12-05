package com.ironhack.midtermproject.hrms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private DepartmentType name;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee manager;
    public Department(DepartmentType name, Employee employee) {

        this.name = name;
        this.manager = employee;
    }


    public DepartmentType getName() {
        return name;
    }

    public void setName(DepartmentType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name=" + name +
                "manager id=" + manager +
                '}';
    }
}
