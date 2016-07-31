package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 31.07.2016.
 */
@Transactional(readOnly = true)
public interface ProxyInsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {

    @Override
    List<InsuranceCompany> findAll();

    @Transactional
    @Modifying
    @Query("delete from InsuranceCompany company where company.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    InsuranceCompany save(InsuranceCompany company);

    @Override
    InsuranceCompany findOne(Integer id);

    @Query("select company from InsuranceCompany company where company.amount between :min and :max order by company.amount desc ")
    List<InsuranceCompany> getFilteredByAmount(int min, int max);

    @Query("select company from InsuranceCompany company where company.franchise between :min and :max order by company.franchise desc ")
    List<InsuranceCompany> getFilteredByFranchise(int min, int max);
}
