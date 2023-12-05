# Human Resources Management System
It is a software system that helps businesses manage their human resources processes, such as employee data management.  
HRMS systems can help businesses to automate tasks, streamline processes, and improve visibility into their workforce.

# Table Of Content
1. [Class Diagram For HRMS](#class-diagram-for-hrms)
2. [Setup](#setup)
3. [Controllers and Routes structure](#controllers-and-routes-structure)
4. [Extra links(Trello, Presentation Slides, etc…)](#extra-links)
5. [Future Work](#future-work)
6. [Resources](#resources)
7. [Owner](#owner)

## Class Diagram For HRMS:

![class diagram.png](class%20diagram.png)

## Setup:
- To Setup The project use Spring initializer to have the following:
  1. Java 17
  2. Maven
 
## Technologies And Tools Used:
1. Spring Boot 3.1.5
2. Maven
3. Junit 5
4. Postman 

## Controllers and Routes created:

* `CompanyController`:
   * `/hrms/companies`: Get all companies
   * `/hrms/company`: Add new company
* `DepartmentController`:
   * `/hrms/departments`: Get all departments
   * `/hrms/department`:Add new department
   * `/hrms/department/3`:Add department manager
* `EmployeeController`:
   * `/hrms/employees`:Get All employees
   * `/hrms/employees/4`:Get employee by id
   * `/hrms/employees`: Add new employee
   * `/hrms/employees/2`:Update employee 
   * `/hrms/employees/isAdmin/2`: Update employee's isAdmin 
   * `/hrms/employee/29`:Delete employee
   

## Extra links:
* [My presentation on slides.com](https://slides.com/nuhaalansari/desk-f2b062/fullscreen)
## Future Work:

Add new features like: following up employees' attendance and vacations, update employees' salaries based on their achievements and upgrades. 

## Resources:
* [Spring Boot tutorial](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiKxZ2ImZKCAxXCaqQEHW7xBdYQFnoECAsQAQ&url=https%3A%2F%2Fwww.baeldung.com%2Fspring-boot&usg=AOvVaw2kqmeShetU7zL-hauDrCxK&opi=89978449)

## Developer Name:
Nuha Alansari.