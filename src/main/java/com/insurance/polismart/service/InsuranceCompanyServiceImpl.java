package com.insurance.polismart.service;

import com.insurance.polismart.exception.ExceptionUtil;
import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.polismart.repository.InsuranceCompanyRepository;

import java.util.List;

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
        ExceptionUtil.checkNotFound(repository.delete(id));
    }

    @Override
    public void update(InsuranceCompany company) {
        ExceptionUtil.checkNotFound(repository.save(company));
    }

    @Override
    public InsuranceCompany get(int id) {
        return ExceptionUtil.checkNotFound(repository.get(id));
    }

    @Override
    public List<InsuranceCompany> getAll() {
        return repository.getAll();
    }

    @Override
    public List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise,
                                                    Integer maxFranchise, String population, String engine_power) {
        return repository.getFilteredByData(minAmount, maxAmount, minFranchise, maxFranchise, population, engine_power);
    }
}
