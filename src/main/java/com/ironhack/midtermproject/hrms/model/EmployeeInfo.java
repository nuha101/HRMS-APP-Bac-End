package com.ironhack.midtermproject.hrms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeInfo {

    private String firstName;
    private String lastName;
    private Double salary;

    private boolean isAdmin;

    public EmployeeInfo(){
        this.isAdmin = false;
    }
    public EmployeeInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = 5000.0;
        this.isAdmin = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @JsonProperty("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }


    @JsonProperty("isAdmin")
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", isAdmin=" + isAdmin +
                '}';
    }

}
