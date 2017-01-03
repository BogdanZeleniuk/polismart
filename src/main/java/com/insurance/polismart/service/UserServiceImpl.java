package com.insurance.polismart.service;

import com.insurance.polismart.AuthorizedUser;
import com.insurance.polismart.dto.UserDTO;
import com.insurance.polismart.dto.UserUtil;
import com.insurance.polismart.exception.NotFoundException;
import com.insurance.polismart.model.User;
import com.insurance.polismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public void delete(int user_id) {
        userRepository.delete(user_id);
    }

    @Override
    public User get(int user_id) {
        return userRepository.get(user_id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public void update(UserDTO user) throws NotFoundException {
        User newUser = get(user.getId());
        UserUtil.updateUserFromDTO(newUser, user);
        userRepository.save(UserUtil.prepareToSave(newUser));
    }

    @Override
    public User getByEmail(String email) {
        return Objects.requireNonNull(userRepository.getByEmail(email));
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.getByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(u);
    }

}
