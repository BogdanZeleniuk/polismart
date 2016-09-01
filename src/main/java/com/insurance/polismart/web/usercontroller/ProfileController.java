package com.insurance.polismart.web.usercontroller;

import com.insurance.polismart.LoggedUser;
import com.insurance.polismart.model.User;
import org.springframework.stereotype.Controller;

/**
 * Created by Admin on 06.07.2016.
 */
@Controller
public class ProfileController extends AbstractUserController {

    public User get() {
        return super.get(LoggedUser.getId());
    }

    public void update(User user) {
        super.update(user, LoggedUser.getId());
    }

    public void delete() {
        super.delete(LoggedUser.getId());
    }
}
