package com.insurance.polismart.service.jdbc;

import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;
import com.insurance.polismart.service.UserServiceImplTest;
import org.junit.Assert;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.JDBC;
import static com.insurance.polismart.UserTestData.ADMIN;
import static com.insurance.polismart.UserTestData.USER;
import static com.insurance.polismart.UserTestData.USERS_WITH_ORDER;

@ActiveProfiles({JDBC,ACTIVE_DB})
public class JdbcUserServiceImplTest extends UserServiceImplTest{

    @Override
    public void testSave() throws Exception {
        User newUser = new User(null, "userNew", "userNew@gmail.com", "usernewusernew", true, Collections.singleton(Role.ROLE_USER));
        userService.save(newUser);
        Assert.assertArrayEquals(new User[]{newUser,USER,ADMIN}, userService.getAll().toArray());
    }

    @Override
    public void testGetAll() throws Exception {
        Assert.assertArrayEquals(USERS_WITH_ORDER.toArray(), userService.getAll().toArray());
    }
}
