package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.service.InsuranceCompanyService;
import com.insurance.polismart.web.AbstractControllerTest;
import com.insurance.polismart.web.json.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.insurance.polismart.InsuranceCompanyTestData.*;
import static com.insurance.polismart.TestUtil.authorize;
import static com.insurance.polismart.TestUtil.userHttpBasic;
import static com.insurance.polismart.UserTestData.ADMIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InsuranceCompanyRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = "/rest/insurance/";

    @Autowired
    private InsuranceCompanyService insuranceCompanyService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + COMPANY_ONE.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + COMPANY_ONE.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(REST_URL + COMPANY_ONE.getId())
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testDelete() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(delete(REST_URL + COMPANY_ONE.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());
        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_FOUR,COMPANY_SIX,COMPANY_TWO,COMPANY_THREE,COMPANY_FIVE},
                        insuranceCompanyService.getAll().toArray());
    }

    @Test
    public void testUpdate() throws Exception {
        authorize(ADMIN);
        InsuranceCompany updatedInsuranceCompany = new InsuranceCompany(6, null, "AXA","The best French insurance company",1000,"Kiev","to 1.6",1296);

        mockMvc.perform(put(REST_URL + COMPANY_ONE.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedInsuranceCompany))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());

        Assert.assertEquals(updatedInsuranceCompany, insuranceCompanyService.get(6));
    }

    @Test
    public void testCreate() throws Exception {
        authorize(ADMIN);
        InsuranceCompany newInsuranceCompany = new InsuranceCompany(null, null, "UNIQA", "Good company", 1000, "Kiev district", "more than 3.0", 1498);
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newInsuranceCompany))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful());

        Assert.assertEquals(7,insuranceCompanyService.getAll().size());
    }

    @Test
    public void testGetAll() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        Assert.assertArrayEquals(COMPANIES.toArray(), insuranceCompanyService.getAll().toArray());
    }

    @Test
    public void testFilter() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(get(REST_URL + "filterByData")
                .param("minAmount", "0").param("maxAmount", "1000")
                .param("minFranchise", "0").param("maxFranchise", "1000")
                .param("population", "Kiev").param("engine_power", "to 1.6")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        Assert.assertArrayEquals(new InsuranceCompany[]{COMPANY_THREE, COMPANY_FIVE},
                insuranceCompanyService.getFilteredByData(0,1000,0,1000,"Kiev","to 1.6").toArray());
    }
}