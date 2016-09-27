package com.insurance.polismart.service;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.polismart.repository.InsuranceCompanyRepository;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {

    @Autowired
    private InsuranceCompanyRepository repository;

    @Override
    public InsuranceCompany save(InsuranceCompany company) {
        return repository.save(company);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(InsuranceCompany company) {
        repository.save(company);
    }

    @Override
    public InsuranceCompany get(int id) {
        return repository.get(id);
    }

    @Override
    public List<InsuranceCompany> getAll() {
        return repository.getAll();
    }

    @Override
    public List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise, Integer maxFranchise) {
        return repository.getFilteredByData(minAmount, maxAmount, minFranchise, maxFranchise);
    }
}
