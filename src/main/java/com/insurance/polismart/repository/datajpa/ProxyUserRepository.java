package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Override
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name")
    List<User> findAll();

    @Override
    @Transactional
    User save(User save);

    @Transactional
    @Query("DELETE FROM User u WHERE u.id=:id")
    @Modifying
    int delete(@Param("id") int id);

    @Override
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id=:id")
    User findOne(@Param("id") Integer id);

    User getByEmail(String email);
}
