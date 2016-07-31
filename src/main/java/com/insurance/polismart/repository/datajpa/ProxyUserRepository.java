package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.model.User;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 20.07.2016.
 */
@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Override
    @Query("select distinct u from User u left join fetch u.roles order by u.name")
    List<User> findAll();

    @Override
    @Transactional
    User save(User save);

    @Transactional
    @Query("delete from User u where u.id=:id")
    @Modifying
    int delete(@Param("id") int id);

    @Override
    @Query("select distinct u from User u LEFT join fetch u.roles where u.id=:id")
    User findOne(@Param("id") Integer id);

    User getByEmail(String email);
}
