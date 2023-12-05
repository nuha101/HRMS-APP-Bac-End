package com.ironhack.midtermproject.hrms.repository;

import com.ironhack.midtermproject.hrms.model.Company;
import com.ironhack.midtermproject.hrms.model.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{


}
