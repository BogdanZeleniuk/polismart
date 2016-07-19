package com.insurance.polismart.repository;

import com.insurance.polismart.model.InsuranceCompany;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
public interface InsuranceCompanyRepository {

    InsuranceCompany save(InsuranceCompany company);

    InsuranceCompany get(int id);

    boolean delete(int id);

    List<InsuranceCompany> getAll();

    List<InsuranceCompany> getFilteredByAmount(int min, int max);

    List<InsuranceCompany> getFilteredByFranchise(int min, int max);

}
