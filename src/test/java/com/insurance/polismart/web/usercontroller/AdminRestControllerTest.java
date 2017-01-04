package com.insurance.polismart.web.usercontroller;

import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;
import com.insurance.polismart.service.UserService;
import com.insurance.polismart.web.AbstractControllerTest;
import com.insurance.polismart.web.json.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Collections;

import static com.insurance.polismart.TestUtil.authorize;
import static com.insurance.polismart.TestUtil.userHttpBasic;
import static com.insurance.polismart.UserTestData.ADMIN;
import static com.insurance.polismart.UserTestData.USER;
import static com.insurance.polismart.UserTestData.USERS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = "/rest/admin/users/";

    @Autowired
    private UserService userService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + ADMIN.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + ADMIN.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(REST_URL + ADMIN.getId())
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void testDelete() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(delete(REST_URL + USER.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());
        Assert.assertArrayEquals(new User[]{ADMIN}, userService.getAll().toArray());
    }

    @Test
    public void testUpdate() throws Exception {
        authorize(ADMIN);
        User updatedUser = new User(2, "Admin", "admin@gmail.com", "adminadminadmin", Role.ROLE_ADMIN);

        mockMvc.perform(put(REST_URL + ADMIN.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedUser))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());

        Assert.assertEquals(updatedUser, userService.get(2));
    }

    @Test
    public void testCreate() throws Exception {
        authorize(ADMIN);
        User newUser = new User(9, "userNew", "userNew@gmail.com", "usernewusernew", true, Collections.singleton(Role.ROLE_USER));
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newUser))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful());

        Assert.assertArrayEquals(new User[]{ADMIN,USER,newUser}, userService.getAll().toArray());
    }

    @Test
    public void testGetAll() throws Exception {
        authorize(ADMIN);
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        Assert.assertArrayEquals(USERS.toArray(), userService.getAll().toArray());
    }
}