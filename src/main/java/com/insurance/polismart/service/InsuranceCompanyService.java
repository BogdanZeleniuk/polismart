package com.insurance.polismart.service;

import com.insurance.polismart.exception.NotFoundException;
import com.insurance.polismart.model.InsuranceCompany;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
public interface InsuranceCompanyService {

    InsuranceCompany save(InsuranceCompany company);

    void delete(int id) throws NotFoundException;

    void update(InsuranceCompany company) throws NotFoundException;

    InsuranceCompany get(int id) throws NotFoundException;

    List<InsuranceCompany> getAll();

    List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise, Integer maxFranchise);

}
