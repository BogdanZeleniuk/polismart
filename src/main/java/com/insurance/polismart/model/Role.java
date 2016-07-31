package com.insurance.polismart.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Admin on 29.06.2016.
 */
public enum Role implements GrantedAuthority {
    USER_ROLE,
    ADMIN_ROLE;

    @Override
    public String getAuthority() {
        return name();
    }
}
