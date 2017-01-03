package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyInsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {

    @Override
    List<InsuranceCompany> findAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM InsuranceCompany company WHERE company.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    InsuranceCompany save(InsuranceCompany company);

    @Override
    InsuranceCompany findOne(Integer id);

    @SuppressWarnings(value = "JpaQlInspection")
    @Query("SELECT company FROM InsuranceCompany company WHERE " +
            "company.amount BETWEEN :minAmount AND :maxAmount AND company.franchise BETWEEN :minFranchise AND :maxFranchise " +
            "AND company.population=:population AND company.engine_power=:engine_power ORDER BY company.amount DESC")
    List<InsuranceCompany> getFilteredByData(@Param ("minAmount") Integer minAmount, @Param ("maxAmount") Integer maxAmount,
                                             @Param ("minFranchise") Integer minFranchise, @Param("maxFranchise") Integer maxFranchise,
                                             @Param ("population") String population, @Param("engine_power") String engine_power);
}
