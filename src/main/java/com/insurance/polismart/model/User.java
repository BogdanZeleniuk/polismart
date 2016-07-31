package com.insurance.polismart.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Admin on 29.06.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = User.GET_ALL, query = "select distinct u from User u left join fetch u.roles order by u.name"),
                @NamedQuery(name = User.DELETE, query = "delete from User u where u.id=:id"),
                @NamedQuery(name = User.GET, query = "select distinct u from User u left join fetch u.roles where u.id=:id"),
                @NamedQuery(name = User.GET_BY_EMAIL, query = "select distinct u from User u left join fetch u.roles where u.email=:email")
        }
)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "email_idx")})
public class User extends NamedEntity{

    public static final String GET_ALL = "User.Get_ALL_SORTED";
    public static final String DELETE = "User.DELETE";
    public static final String GET = "User.GET";
    public static final String GET_BY_EMAIL = "User.Get_By_Email";

    @Email
    @Column(name = "email", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @NotEmpty
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6, max = 20)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "registered")
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
        this.roles = roles;
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
