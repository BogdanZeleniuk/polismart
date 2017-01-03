package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.repository.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaInsuranceCompanyRepositoryImpl implements InsuranceCompanyRepository {

    @Autowired
    ProxyInsuranceCompanyRepository proxyInsuranceCompanyRepository;

    @Override
    public InsuranceCompany save(InsuranceCompany company) {
        return proxyInsuranceCompanyRepository.save(company);
    }

    @Override
    public InsuranceCompany get(int id) {
        return proxyInsuranceCompanyRepository.findOne(id);
    }

    @Override
    public boolean delete(int id) {
        return proxyInsuranceCompanyRepository.delete(id) != 0;
    }

    @Override
    public List<InsuranceCompany> getAll() {
        return proxyInsuranceCompanyRepository.findAll();
    }

    @Override
    public List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise,
                                                    Integer maxFranchise, String population, String engine_power) {
        return proxyInsuranceCompanyRepository.getFilteredByData(minAmount, maxAmount, minFranchise, maxFranchise,
                                                                population, engine_power);
    }
}
