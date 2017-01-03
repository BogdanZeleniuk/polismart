package com.insurance.polismart.service;

import com.insurance.polismart.dto.UserDTO;
import com.insurance.polismart.exception.NotFoundException;
import com.insurance.polismart.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int user_id) throws NotFoundException;

    User get(int user_id) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;

    void update(UserDTO user) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;
}
