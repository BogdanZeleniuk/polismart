package com.insurance.polismart.service;

import com.insurance.polismart.model.InsuranceCompany;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
public interface InsuranceCompanyService {

    InsuranceCompany save(InsuranceCompany company);

    void delete(int id);

    void update(InsuranceCompany company);

    InsuranceCompany get(int id);

    List<InsuranceCompany> getAll();

    List<InsuranceCompany> getFilteredByAmount(int min, int max);

    List<InsuranceCompany> getFilteredByFranchise(int min, int max);
}
