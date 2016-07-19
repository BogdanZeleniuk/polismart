package com.insurance.polismart.web.controller;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Admin on 06.07.2016.
 */
@Controller
public class InsuranceCompanyController {

    @Autowired
    private InsuranceCompanyService companyService;

    public InsuranceCompany create(InsuranceCompany company){
        company.setId(null);
        return companyService.save(company);
    }

    public void delete(int id){
        companyService.delete(id);
    }

    public void update(InsuranceCompany company, int id){
        company.setId(id);
        companyService.update(company);
    }

    public InsuranceCompany get(int id){
        return companyService.get(id);
    }

    public List<InsuranceCompany> getAll(){
        return companyService.getAll();
    }

    public List<InsuranceCompany> getFilteredByAmount(int min, int max){
        return companyService.getFilteredByAmount(min, max);
    }

    public List<InsuranceCompany> getFilteredByFranchise(int min, int max){
        return companyService.getFilteredByFranchise(min, max);
    }
}
