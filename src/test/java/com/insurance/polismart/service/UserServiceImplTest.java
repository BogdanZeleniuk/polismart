package com.insurance.polismart.service;

import com.insurance.polismart.SpringBootWebApplication;
import com.insurance.polismart.exception.NotFoundException;
import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static com.insurance.polismart.UserTestData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SpringBootWebApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class UserServiceImplTest {

    @Autowired
    protected UserService userService;

    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "userNew", "userNew@gmail.com", "usernewusernew", true, Collections.singleton(Role.ROLE_USER));
        userService.save(newUser);
        Assert.assertArrayEquals(new User[]{ADMIN,USER,newUser}, userService.getAll().toArray());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        userService.save(new User(null, "userNew", "user@ukr.net", "usernewusernew", Role.ROLE_USER));
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(USER.getId());
        Assert.assertArrayEquals(new User[]{ADMIN}, userService.getAll().toArray());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        userService.delete(3);
    }

    @Test
    public void testGet() throws Exception {
        User user = userService.get(2);
        Assert.assertEquals(ADMIN, user);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        userService.get(3);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = userService.getByEmail("user@ukr.net");
        Assert.assertEquals(USER, user);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(USERS.toArray(), userService.getAll().toArray());
    }

    @Test
    public void testUpdate() throws Exception {
        User updatedUser = new User(2, "Admin", "admin@gmail.com", "adminadminadmin", Role.ROLE_ADMIN);
        userService.update(updatedUser);
        Assert.assertEquals(updatedUser, userService.get(2));
    }
}
