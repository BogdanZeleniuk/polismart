package com.insurance.polismart.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.insurance.polismart.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@NamedQueries(
        {
                @NamedQuery(name = User.GET_ALL, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name"),
                @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
                @NamedQuery(name = User.GET, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id=:id"),
                @NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=:email")
        }
)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "email_idx")})
public class User extends NamedEntity{

    public static final String GET_ALL = "User.GET_ALL_SORTED";
    public static final String DELETE = "User.DELETE";
    public static final String GET = "User.GET";
    public static final String GET_BY_EMAIL = "User.GET_BY_EMAIL";

    @Email
    @Column(name = "email", nullable = false, unique = true)
    @Size(min = 3, max = 30, message = "Email should have more than 3 letters")
    @NotEmpty(message = "Email could not be empty")
    @JsonView(View.REST.class)
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Password could not be empty")
    @Length(min = 6, max = 20, message = "Password should have more than 6 symbols")
    @JsonView(View.REST.class)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "registered")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String email, String password, Role role, Role ... roles) {
        this(id,name,email,password,true, EnumSet.of(role,roles));
    }

    public User(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        setRoles(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.EMPTY_SET : EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
