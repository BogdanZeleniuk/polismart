package com.insurance.polismart.model;

/**
 * Created by Admin on 29.06.2016.
 */

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {

    public static final int GLOBAL_SEQUENCE = 1;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) obj;
        if (id == null || baseEntity.id == null){
            return false;
        }
        return id.equals(baseEntity.id);
    }
}
