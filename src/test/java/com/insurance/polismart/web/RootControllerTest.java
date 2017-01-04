package com.insurance.polismart.web;

import org.junit.Test;

import static com.insurance.polismart.TestUtil.authorize;
import static com.insurance.polismart.UserTestData.ADMIN;
import static com.insurance.polismart.UserTestData.USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RootControllerTest extends AbstractControllerTest{

    @Test
    public void testUserList() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("userList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userList.jsp"));
    }

    @Test
    public void testUserListUnAuth() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void tesInsuranceCompaniesList() throws Exception {
        authorize(USER);
        mockMvc.perform(get("/insurance"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("insuranceCompanyList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/insuranceCompanyList.jsp"));
    }
}