package com.insurance.polismart.dto;

import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;

public class UserUtil {

    public static User createUserFromDTO(UserDTO newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserDTO userAsDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static void updateUserFromDTO(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
    }

    public static User prepareToSave(User user) {
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
