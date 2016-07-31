package com.insurance.polismart;

import com.insurance.polismart.model.BaseEntity;

/**
 * Created by Admin on 06.07.2016.
 */
public class LoggedUser {
    public static int id = BaseEntity.GLOBAL_SEQUENCE;

    public static int getId() {
        return id;
    }
    public static void setId(int id){
        LoggedUser.id = id;
    }
}
