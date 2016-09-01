package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.repository.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 31.07.2016.
 */
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
    public List<InsuranceCompany> getFilteredByAmount(int min, int max) {
        return proxyInsuranceCompanyRepository.getFilteredByAmount(min, max);
    }

    @Override
    public List<InsuranceCompany> getFilteredByFranchise(int min, int max) {
        return proxyInsuranceCompanyRepository.getFilteredByFranchise(min, max);
    }
}
