package com.insurance.polismart.repository;

import com.insurance.polismart.SpringBootWebApplication;
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
public abstract class UserRepositoryImplTest{

    @Autowired
    protected UserRepository userRepository;

    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "userNew", "userNew@gmail.com", "usernewusernew", true, Collections.singleton(Role.ROLE_USER));
        userRepository.save(newUser);
        Assert.assertArrayEquals(new User[]{ADMIN,USER,newUser}, userRepository.getAll().toArray());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        userRepository.save(new User(null, "userNew", "user@ukr.net", "usernewusernew", Role.ROLE_USER));
    }

    @Test
    public void testDelete() throws Exception {
        userRepository.delete(USER.getId());
        Assert.assertArrayEquals(new User[]{ADMIN}, userRepository.getAll().toArray());
    }

    @Test
    public void testGet() throws Exception {
        User user = userRepository.get(2);
        Assert.assertEquals(ADMIN, user);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = userRepository.getByEmail("user@ukr.net");
        Assert.assertEquals(USER, user);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(USERS.toArray(), userRepository.getAll().toArray());
    }

    @Test
    public void testUpdate() throws Exception {
        User updatedUser = new User(2, "Admin", "admin@gmail.com", "adminadminadmin", Role.ROLE_ADMIN);
        userRepository.save(updatedUser);
        Assert.assertEquals(updatedUser, userRepository.get(2));
    }
}
