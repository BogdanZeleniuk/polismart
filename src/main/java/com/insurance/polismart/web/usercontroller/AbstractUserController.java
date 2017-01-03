package com.insurance.polismart.web.usercontroller;

import com.insurance.polismart.dto.UserDTO;
import com.insurance.polismart.model.User;
import com.insurance.polismart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractUserController {

    @Autowired
    private UserService service;

    public User create(User user){
        user.setId(null);
        return service.save(user);
    }

    public void update(User user, int userId){
        user.setId(userId);
        service.update(user);
    }

    public void delete(int userId){
        service.delete(userId);
    }

    public User get(int userId){
        return service.get(userId);
    }

    public void update(UserDTO userDTO) {
        service.update(userDTO);
    }

    public List<User> getAll(){
        return service.getAll();
    }

    public User getByEmail(String email){
        return service.getByEmail(email);
    }

}
