package com.insurance.polismart.repository.jpa;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.repository.InsuranceCompanyRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Primary
@Transactional(readOnly = true)
public class JpaInsuranceCompanyRepositoryImpl implements InsuranceCompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public InsuranceCompany save(InsuranceCompany company) {
        if (company.isNew()){
            entityManager.persist(company);
            return company;
        }
        return entityManager.merge(company);
    }

    @Override
    public InsuranceCompany get(int id) {
        List<InsuranceCompany> list = entityManager.createNamedQuery(InsuranceCompany.GET, InsuranceCompany.class)
                .setParameter("id", id)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(InsuranceCompany.DELETE)
                .setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<InsuranceCompany> getAll() {
        return entityManager.createNamedQuery(InsuranceCompany.GET_All, InsuranceCompany.class).getResultList();
    }

    @Override
    public List<InsuranceCompany> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise,
                                                    Integer maxFranchise, String population, String engine_power) {
        return entityManager.createNamedQuery(InsuranceCompany.FILTERED_BY_DATA, InsuranceCompany.class)
                .setParameter("minAmount", minAmount)
                .setParameter("maxAmount", maxAmount)
                .setParameter("minFranchise", minFranchise)
                .setParameter("maxFranchise", maxFranchise)
                .setParameter("population", population)
                .setParameter("engine_power", engine_power)
                .getResultList();
    }
}
