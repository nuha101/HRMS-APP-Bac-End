package com.ironhack.midtermproject.hrms.service.interfaces;

import com.ironhack.midtermproject.hrms.model.Company;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface ICompanyService {

    Optional<Company> getCompanyById(Integer id);
}
