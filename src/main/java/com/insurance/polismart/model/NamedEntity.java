package com.insurance.polismart.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.insurance.polismart.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @Column( name = "name", nullable = false, unique = true)
    @NotEmpty(message = "Name could not be empty")
    @JsonView(View.REST.class)
    @Length(min = 3, max = 50, message = "More than 3 symbols")
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
