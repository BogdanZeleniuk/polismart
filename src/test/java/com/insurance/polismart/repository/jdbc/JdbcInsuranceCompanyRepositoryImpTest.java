package com.insurance.polismart.repository.jdbc;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.repository.InsuranceCompanyRepositoryImplTest;
import org.junit.Assert;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.InsuranceCompanyTestData.*;
import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.JDBC;

@ActiveProfiles({JDBC,ACTIVE_DB})
public class JdbcInsuranceCompanyRepositoryImpTest extends InsuranceCompanyRepositoryImplTest{

    @Override
    public void testSave() throws Exception {
        InsuranceCompany newInsuranceCompany = new InsuranceCompany(null, null, "UNIQA", "Good company", 1000, "Kiev district", "more than 3.0", 1498);
        insuranceCompanyRepository.save(newInsuranceCompany);
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FIVE,COMPANY_THREE,COMPANY_TWO,COMPANY_ONE,COMPANY_SIX,COMPANY_FOUR,newInsuranceCompany},
                insuranceCompanyRepository.getAll().toArray());
    }

    @Override
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(COMPANIES_WITH_JDBC.toArray(), insuranceCompanyRepository.getAll().toArray());
    }

    @Override
    public void testDelete() throws Exception {
        insuranceCompanyRepository.delete(COMPANY_ONE.getId());
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FIVE,COMPANY_THREE,COMPANY_TWO,COMPANY_SIX,COMPANY_FOUR},
                insuranceCompanyRepository.getAll().toArray());
    }
}
