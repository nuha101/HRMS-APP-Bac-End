package com.ironhack.midtermproject.hrms.service.impl;

import com.ironhack.midtermproject.hrms.model.Company;
import com.ironhack.midtermproject.hrms.repository.CompanyRepository;
import com.ironhack.midtermproject.hrms.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Optional<Company> getCompanyById(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company Not found ");
        return Optional.of(companyOptional.get());
    }
}
