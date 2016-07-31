package com.insurance.polismart.repository.jpa;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.repository.InsuranceCompanyRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 20.07.2016.
 */
@Repository
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
    public List<InsuranceCompany> getFilteredByAmount(int min, int max) {
        return entityManager.createNamedQuery(InsuranceCompany.FILTERED_BY_AMOUNT, InsuranceCompany.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public List<InsuranceCompany> getFilteredByFranchise(int min, int max) {
        return entityManager.createNamedQuery(InsuranceCompany.FILTERED_BY_FRANCHISE, InsuranceCompany.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
}
