package com.insurance.polismart.service.datajpa;


import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyServiceImplTest;
import org.junit.Assert;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.InsuranceCompanyTestData.*;
import static com.insurance.polismart.InsuranceCompanyTestData.COMPANY_FIVE;
import static com.insurance.polismart.InsuranceCompanyTestData.COMPANY_THREE;
import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.DATAJPA;

@ActiveProfiles({DATAJPA,ACTIVE_DB})
public class DataJpaInsuranceCompanyServiceTest extends InsuranceCompanyServiceImplTest{

    @Override
    public void testSave() throws Exception {
        InsuranceCompany newInsuranceCompany = new InsuranceCompany(null, null, "UNIQA", "Good company", 1000, "Kiev district", "more than 3.0", 1498);
        insuranceCompanyService.save(newInsuranceCompany);
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_ONE,COMPANY_TWO,COMPANY_THREE,COMPANY_FOUR,COMPANY_FIVE,COMPANY_SIX,newInsuranceCompany},
                insuranceCompanyService.getAll().toArray());
    }

    @Override
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(COMPANIES_WITH_ORDER.toArray(), insuranceCompanyService.getAll().toArray());
    }

    @Override
    public void testDelete() throws Exception {
        insuranceCompanyService.delete(COMPANY_ONE.getId());
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_TWO,COMPANY_THREE,COMPANY_FOUR,COMPANY_FIVE,COMPANY_SIX},
                insuranceCompanyService.getAll().toArray());
    }
}
