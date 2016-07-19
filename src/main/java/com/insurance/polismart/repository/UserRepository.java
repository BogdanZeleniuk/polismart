package com.insurance.polismart.repository;

import com.insurance.polismart.model.User;

import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
public interface UserRepository {

    User save(User user);

    boolean delete(int user_id);

    User get(int user_id);

    List<User> getAll();

    User getByEmail(String email);

}
