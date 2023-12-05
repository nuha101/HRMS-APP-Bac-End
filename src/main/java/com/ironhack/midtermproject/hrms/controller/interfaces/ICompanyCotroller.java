package com.ironhack.midtermproject.hrms.controller.interfaces;

import com.ironhack.midtermproject.hrms.model.Company;
import com.ironhack.midtermproject.hrms.model.DepartmentType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ICompanyCotroller {

    public List<Company> getAllCompany();
    public Optional<Company> getCompanyById( Integer id);

}
