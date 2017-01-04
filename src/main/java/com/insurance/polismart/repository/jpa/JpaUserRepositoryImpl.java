package com.insurance.polismart.repository.jpa;

import com.insurance.polismart.model.User;
import com.insurance.polismart.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.insurance.polismart.Profiles.JPA;

@Repository
@Profile(JPA)
@Transactional(readOnly = true)
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public boolean delete(int user_id) {
        return entityManager.createNamedQuery(User.DELETE)
                .setParameter("id", user_id).executeUpdate() != 0;
    }

    @Override
    public User get(int user_id) {
        List<User> userList = entityManager.createNamedQuery(User.GET, User.class)
                .setParameter("id", user_id)
                .getResultList();
        return DataAccessUtils.singleResult(userList);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery(User.GET_ALL, User.class).getResultList();
    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        try {
            result = entityManager.createNamedQuery(User.GET_BY_EMAIL, User.class).setParameter("email", email).getSingleResult();
        }
        catch (NoResultException | EmptyResultDataAccessException ignored){

        }
        return result;
    }
}
