package com.insurance.polismart.web.controller;

import com.insurance.polismart.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Admin on 06.07.2016.
 */
@Controller
public class AdminController extends AbstractUserController {

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void update(User user, int userId) {
        super.update(user, userId);
    }

    @Override
    public void delete(int userId) {
        super.delete(userId);
    }

    @Override
    public User get(int userId) {
        return super.get(userId);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User getByEmail(String email) {
        return super.getByEmail(email);
    }
}
