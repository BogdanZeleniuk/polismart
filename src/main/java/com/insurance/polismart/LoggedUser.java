package com.insurance.polismart;

import com.insurance.polismart.model.BaseEntity;
import com.insurance.polismart.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Admin on 06.07.2016.
 */
public class LoggedUser  extends org.springframework.security.core.userdetails.User{
    public static int id = BaseEntity.GLOBAL_SEQUENCE;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
    }

    public static int getId() {
        return id;
    }
    public static void setId(int id){
        LoggedUser.id = id;
    }
}
