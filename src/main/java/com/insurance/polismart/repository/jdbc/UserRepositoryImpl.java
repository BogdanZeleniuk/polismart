package com.insurance.polismart.repository.jdbc;

import com.insurance.polismart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.insurance.polismart.repository.UserRepository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final BeanPropertyRowMapper<User> MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User save(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id",user.getId())
                .addValue("name",user.getName())
                .addValue("email",user.getEmail())
                .addValue("password",user.getPassword())
                .addValue("enabled",user.isEnabled())
                .addValue("registered", user.getRegistered());

        if (user.isNew()){
            Number newId = jdbcInsert.executeAndReturnKey(mapSqlParameterSource);
            user.setId(newId.intValue());
        }
        else {
            namedParameterJdbcTemplate.update("" +
                    "UPDATE users SET name=:name, email=:email, password=:password, enabled=:enabled, registered=:registered WHERE id=:id",mapSqlParameterSource);
        }
        return user;
    }

    @Override
    public boolean delete(int user_id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?",user_id) != 0;
    }

    @Override
    public User get(int user_id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE id=?",MAPPER,user_id);
        return DataAccessUtils.singleResult(userList);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name DESC ",MAPPER);
    }

    @Override
    public User getByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?",MAPPER,email);
    }
}
