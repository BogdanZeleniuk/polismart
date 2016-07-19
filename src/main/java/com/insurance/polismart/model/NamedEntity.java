package com.insurance.polismart.model;

/**
 * Created by Admin on 29.06.2016.
 */
public class NamedEntity extends BaseEntity{

    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(int id, String name) {
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
