package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.AuthorizedUser;
import com.insurance.polismart.dto.InsuranceCompanyDTO;
import com.insurance.polismart.dto.InsuranceCompanyUtil;
import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyService;
import com.insurance.polismart.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractInsuranceCompanyController {

    private static final int MIN_AMOUNT = 0;
    private static final int MAX_AMOUNT = 10000;
    private static final int MIN_FRANCHISE = 0;
    private static final int MAX_FRANCHISE = 10000;
    private static final String POPULATION = "Kiev";
    private static final String ENGINE_POWER = "to 1.6";

    private static final Logger LOG = LoggerFactory.getLogger(AbstractInsuranceCompanyController.class);

    @Autowired
    private InsuranceCompanyService companyService;

    @Autowired
    private UserService service;

    public InsuranceCompany create(InsuranceCompany company){
        company.setId(null);
        int userId = AuthorizedUser.id();
        LOG.info("create() company '" + company + "' for User with id '" + userId + "'");
        return companyService.save(company);
    }

    public void delete(int id){
        int userId = AuthorizedUser.id();
        LOG.info("delete() company with id '" + id + "' for User with id '" + userId + "'");
        companyService.delete(id);
    }

    public void update(InsuranceCompany company, int id){
        company.setId(id);
        int userId = AuthorizedUser.id();
        LOG.info("update() company with id '" + id + "' for User with id '" + userId + "'");
        companyService.update(company);
    }

    public InsuranceCompany get(int id){
        int userId = AuthorizedUser.id();
        LOG.info("get() company with id '" + id + "' for User with id '" + userId + "'");
        return companyService.get(id);
    }

    public List<InsuranceCompanyDTO> getAll(){
        int userId = AuthorizedUser.id();
        LOG.info("getAll() companies for User with id '" + userId + "'");
        LOG.info("User info: " + service.get(userId));
        return InsuranceCompanyUtil.getInsuranceCompanyDTOFromInsuranceCompany(companyService.getAll());
    }

    public List<InsuranceCompanyDTO> getFilteredByData(Integer minAmount, Integer maxAmount, Integer minFranchise,
                                                    Integer maxFranchise, String population, String engine_power){
        int userId = AuthorizedUser.id();
        LOG.info("getFilteredByData() companies for User with id '" + userId + "'");
        LOG.info("User info: " + service.get(userId));
        return InsuranceCompanyUtil.getInsuranceCompanyDTOFromInsuranceCompany(companyService.getFilteredByData(minAmount != null ? minAmount : MIN_AMOUNT,
                maxAmount != null ? maxAmount : MAX_AMOUNT, minFranchise != null ? minFranchise : MIN_FRANCHISE,
                maxFranchise != null ? maxFranchise : MAX_FRANCHISE, population != null ? population : POPULATION,
                engine_power != null ? engine_power : ENGINE_POWER));
    }
}
