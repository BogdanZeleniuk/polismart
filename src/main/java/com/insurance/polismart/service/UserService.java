package com.insurance.polismart.service;

import com.insurance.polismart.model.User;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
public interface UserService {

    User save(User user);

    void delete(int user_id);

    User get(int user_id);

    List<User> getAll();

    void update(User user);

    User getByEmail(String email);

}
