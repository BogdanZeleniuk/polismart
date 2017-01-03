package com.insurance.polismart.repository;

import com.insurance.polismart.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int user_id);

    User get(int user_id);

    List<User> getAll();

    User getByEmail(String email);

}
