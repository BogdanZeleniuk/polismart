package com.insurance.polismart.repository.jdbc;

import com.insurance.polismart.model.Role;
import com.insurance.polismart.model.User;
import com.insurance.polismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.insurance.polismart.Profiles.JDBC;

@Repository
@Transactional(readOnly = true)
@Profile(JDBC)
public class UserRepositoryImpl implements UserRepository {

    private static final BeanPropertyRowMapper<User> MAPPER = BeanPropertyRowMapper.newInstance(User.class);
    private static final RowMapper<Role> ROLE_ROW_MAPPER = (rs, rowNum) -> Role.valueOf(rs.getString("role"));

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
    @Transactional
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
            insertRoles(user);
        }
        else {
            deleteRoles(user);
            insertRoles(user);
            namedParameterJdbcTemplate.update("" +
                    "UPDATE users SET name=:name, email=:email, password=:password, enabled=:enabled, registered=:registered WHERE id=:id",mapSqlParameterSource);
        }
        return user;
    }

    @Override
    @Transactional
    public boolean delete(int user_id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?",user_id) != 0;
    }

    @Override
    public User get(int user_id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE id=?",MAPPER,user_id);
        return setRoles(DataAccessUtils.singleResult(userList));
    }

    @Override
    public List<User> getAll() {
        class UserRole {
            final private Role role;
            final private int userId;

            UserRole(Role role, int userId) {
                this.role = role;
                this.userId = userId;
            }

            public Role getRole() {
                return role;
            }

            public int getUserId() {
                return userId;
            }
        }

        Map<Integer, List<Role>> userRolesMap = jdbcTemplate.query("SELECT role, user_id FROM user_roles",
                (rs, rowNum) -> new UserRole(Role.valueOf(rs.getString("role")), rs.getInt("user_id"))).stream()
                .collect(
                        Collectors.groupingBy(UserRole::getUserId, Collectors.mapping(UserRole::getRole, Collectors.toList()))
                );

        List<User> users = jdbcTemplate.query("SELECT * FROM users ORDER BY name DESC ",MAPPER);
        users.forEach(u -> u.setRoles(userRolesMap.get(u.getId())));
        return users;
    }

    @Override
    public User getByEmail(String email) {
        return setRoles(jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?",MAPPER,email));
    }

    private void insertRoles(User u) {
        Set<Role> roles = u.getRoles();
        Iterator<Role> iterator = roles.iterator();

        jdbcTemplate.batchUpdate("INSERT INTO user_roles (user_id, role) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, u.getId());
                        ps.setString(2, iterator.next().name());
                    }

                    @Override
                    public int getBatchSize() {
                        return roles.size();
                    }
                });
    }

    private void deleteRoles(User u) {
        jdbcTemplate.update("DELETE FROM user_roles WHERE user_id=?", u.getId());
    }

    private User setRoles(User u) {
        if (u != null) {
            List<Role> roles = jdbcTemplate.query("SELECT role FROM user_roles  WHERE user_id=?",
                    ROLE_ROW_MAPPER, u.getId());
            u.setRoles(roles);
        }
        return u;
    }
}
