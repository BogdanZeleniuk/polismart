package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.User;
import com.insurance.polismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.insurance.polismart.Profiles.DATAJPA;

@Repository
@Profile(DATAJPA)
public class DataJpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private ProxyUserRepository proxyUserRepository;

    @Override
    public User save(User user) {
        return proxyUserRepository.save(user);
    }

    @Override
    public boolean delete(int user_id) {
        return proxyUserRepository.delete(user_id) != 0;
    }

    @Override
    public User get(int user_id) {
        return proxyUserRepository.findOne(user_id);
    }

    @Override
    public List<User> getAll() {
        return proxyUserRepository.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return proxyUserRepository.getByEmail(email);
    }
}
