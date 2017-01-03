package com.insurance.polismart.repository;

import com.insurance.polismart.model.InsuranceCompany;

import java.util.List;

public interface InsuranceCompanyRepository {

    InsuranceCompany save(InsuranceCompany company);

    InsuranceCompany get(int id);

    boolean delete(int id);

    List<InsuranceCompany> getAll();

    List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise,
                                             Integer maxFranchise, String population, String engine_power);
}
