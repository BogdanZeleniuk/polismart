package com.insurance.polismart.service.jdbc;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyServiceImplTest;
import org.junit.Assert;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.InsuranceCompanyTestData.*;
import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.JDBC;

@ActiveProfiles({JDBC,ACTIVE_DB})
public class JdbcInsuranceCompanyServiceTest extends InsuranceCompanyServiceImplTest{

    @Override
    public void testSave() throws Exception {
        InsuranceCompany newInsuranceCompany = new InsuranceCompany(null, null, "UNIQA", "Good company", 1000, "Kiev district", "more than 3.0", 1498);
        insuranceCompanyService.save(newInsuranceCompany);
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FIVE,COMPANY_THREE,COMPANY_TWO,COMPANY_ONE,COMPANY_SIX,COMPANY_FOUR,newInsuranceCompany},
                insuranceCompanyService.getAll().toArray());
    }

    @Override
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(COMPANIES_WITH_JDBC.toArray(), insuranceCompanyService.getAll().toArray());
    }

    @Override
    public void testDelete() throws Exception {
        insuranceCompanyService.delete(COMPANY_ONE.getId());
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FIVE,COMPANY_THREE,COMPANY_TWO,COMPANY_SIX,COMPANY_FOUR},
                insuranceCompanyService.getAll().toArray());
    }
}
