package com.insurance.polismart.web.usercontroller;

import com.insurance.polismart.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 06.07.2016.
 */
@RestController
@RequestMapping("/rest/admin/users")
public class AdminRestController extends AbstractUserController {

    @RequestMapping(method = RequestMethod.POST )
    public ResponseEntity<User> createWithLocation(@RequestBody User user) {
    //    return super.create(user);
        return null;
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
