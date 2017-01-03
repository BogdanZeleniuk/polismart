package com.insurance.polismart.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.insurance.polismart.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Name could not be empty")
    @JsonView(View.REST.class)
    @Length(min = 3, max = 50, message = "More than 3 symbols")
    protected String name;

    @Email
    @Size(min = 3, max = 30, message = "Email should have more than 3 letters")
    @NotEmpty(message = "Email could not be empty")
    @JsonView(View.REST.class)
    private String email;

    @NotEmpty(message = "Password could not be empty")
    @Length(min = 6, max = 20, message = "Password should have more than 6 symbols")
    @JsonView(View.REST.class)
    private String password;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + "'}";
    }
}
