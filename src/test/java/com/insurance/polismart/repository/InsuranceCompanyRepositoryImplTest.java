package com.insurance.polismart.repository;

import com.insurance.polismart.SpringBootWebApplication;
import com.insurance.polismart.model.InsuranceCompany;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.insurance.polismart.InsuranceCompanyTestData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SpringBootWebApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class InsuranceCompanyRepositoryImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    protected InsuranceCompanyRepository insuranceCompanyRepository;

    @Test
    public void testDelete() throws Exception {
        insuranceCompanyRepository.delete(COMPANY_ONE.getId());
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FOUR,COMPANY_SIX,COMPANY_TWO,COMPANY_THREE,COMPANY_FIVE},
                insuranceCompanyRepository.getAll().toArray());
    }


    @Test
    public void testSave() throws Exception {
        InsuranceCompany newInsuranceCompany = new InsuranceCompany(null, null, "UNIQA", "Good company", 1000, "Kiev district", "more than 3.0", 1498);
        insuranceCompanyRepository.save(newInsuranceCompany);
        Assert.assertArrayEquals(new InsuranceCompany[]{newInsuranceCompany, COMPANY_FOUR,COMPANY_SIX,COMPANY_ONE,COMPANY_TWO,COMPANY_THREE,COMPANY_FIVE},
                insuranceCompanyRepository.getAll().toArray());
    }

    @Test
    public void testGet() throws Exception {
        InsuranceCompany getCompany = insuranceCompanyRepository.get(3);
        Assert.assertEquals(COMPANY_ONE, getCompany);
    }

    @Test
    public void testUpdate() throws Exception {
        InsuranceCompany updatedInsuranceCompany = new InsuranceCompany(6, null, "AXA","The best French insurance company",1000,"Kiev","to 1.6",1296);
        insuranceCompanyRepository.save(updatedInsuranceCompany);
        Assert.assertEquals(updatedInsuranceCompany, insuranceCompanyRepository.get(6));
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(COMPANIES.toArray(), insuranceCompanyRepository.getAll().toArray());
    }

    @Test
    public void testGetFiltered() throws Exception {
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_THREE, COMPANY_FIVE},
                insuranceCompanyRepository.getFilteredByData(0,1000,0,1000,"Kiev","to 1.6").toArray());
    }


}