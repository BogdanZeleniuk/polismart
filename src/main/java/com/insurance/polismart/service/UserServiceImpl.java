package com.insurance.polismart.service;

import com.insurance.polismart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.insurance.polismart.repository.UserRepository;

import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 29.06.2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public void delete(int user_id) {
        userRepository.delete(user_id);
    }

    @Override
    public User get(int user_id) {
        return userRepository.get(user_id);
    }

    @Override
    @Cacheable("users")
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return Objects.requireNonNull(userRepository.getByEmail(email));
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictCache() {
    }

}
