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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private int numOfEmployee;
    private int numOfDepartment;


    @ManyToMany
    @JoinTable(name = "company_departments", joinColumns = @JoinColumn(name="company_id"), inverseJoinColumns = @JoinColumn(name="department_id") )
//    @JsonIgnore
    private List<Department> departmentList;


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numOfEmployee=" + numOfEmployee +
                ", numOfDepartment=" + numOfDepartment +
                '}';
    }
}
