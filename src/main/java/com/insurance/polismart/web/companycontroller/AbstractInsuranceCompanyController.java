package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Admin on 06.07.2016.
 */
public abstract class AbstractInsuranceCompanyController {

    private static final int MIN_AMOUNT = 0;
    private static final int MAX_AMOUNT = 10000;
    private static final int MIN_FRANCHISE = 0;
    private static final int MAX_FRANCHISE = 10000;

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

    public List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise, Integer maxFranchise){
        return companyService.getFilteredByData(minAmount != null ? minAmount : MIN_AMOUNT,
                maxAmount != null ? maxAmount : MAX_AMOUNT, minFranchise != null ? minFranchise : MIN_FRANCHISE, maxFranchise != null ? maxFranchise : MAX_FRANCHISE);
    }
}
