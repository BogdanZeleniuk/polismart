package com.insurance.polismart;

import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;

import java.util.Arrays;
import java.util.List;

public class UserTestData {

    public static final User USER = new User(1, "User", "user@ukr.net", "useruser", Role.ROLE_USER);
    public static final User ADMIN = new User(2, "Admin", "admin@gmail.com", "adminadmin", Role.ROLE_ADMIN);

    public static final List<User> USERS = Arrays.asList(ADMIN,USER);
    public static final List<User> USERS_WITH_ORDER = Arrays.asList(USER,ADMIN);

}
