package com.ironhack.midtermproject.hrms.controller.impl;

import com.ironhack.midtermproject.hrms.controller.interfaces.ICompanyCotroller;
import com.ironhack.midtermproject.hrms.model.Company;
import com.ironhack.midtermproject.hrms.model.DepartmentType;
import com.ironhack.midtermproject.hrms.repository.CompanyRepository;
import com.ironhack.midtermproject.hrms.service.impl.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hrms")
public class CompanyController implements ICompanyCotroller {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;

    /*----------------------------------- GET REQUESTS -------------------------------*/

    /* -------- All Comapnies ------------- */
    @GetMapping("/companies")
    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }


    /* ----- Get company by id ----*/
    @GetMapping("/company/{id}")
    public Optional<Company> getCompanyById(@PathVariable Integer id){
        return companyService.getCompanyById(id);
    }

    /*-------------------------------- POST REQUESTS ----------------------------------*/

    /* --------- Add New Company ----------- */
    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewCompany(@RequestBody Company company){
        System.out.println(company.toString());
        companyRepository.save(company);
    }

}
