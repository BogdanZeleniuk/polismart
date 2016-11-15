package com.insurance.polismart.web.usercontroller;

import com.insurance.polismart.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 27.09.2016.
 */
@RestController
@RequestMapping("/ajax/users")
public class AdminAjaxController extends AbstractUserController{

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll (){
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") int id){
        return super.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(User user){
        if (user.isNew()){
            super.create(user);
        }
        else
            super.update(user, user.getId());
    }

    @RequestMapping(value = "/byEmail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByEmail(@RequestParam(value = "email", required = false) String email){
        return super.getByEmail(email);
    }
}
