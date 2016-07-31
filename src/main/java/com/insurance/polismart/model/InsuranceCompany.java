package com.insurance.polismart.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Admin on 29.06.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = InsuranceCompany.GET_All, query = "select company from InsuranceCompany company order by company.amount desc"),
                @NamedQuery(name = InsuranceCompany.DELETE, query = "delete from InsuranceCompany company where company.id=:id"),
                @NamedQuery(name = InsuranceCompany.GET, query = "select company from InsuranceCompany company where company.id=:id"),
                @NamedQuery(name = InsuranceCompany.FILTERED_BY_AMOUNT, query = "select company from InsuranceCompany company where company.amount between :min AND :max order by company.amount desc"),
                @NamedQuery(name = InsuranceCompany.FILTERED_BY_FRANCHISE, query = "select company from InsuranceCompany company where company.franchise between :min and :max order by company.franchise desc")
        }
)
@Entity
@Table(name = "insurance_companies")
public class InsuranceCompany extends BaseEntity{

    public static final String GET_All = "InsuranceCompany.Get_All";
    public static final String DELETE = "InsuranceCompany.Delete";
    public static final String GET = "InsuranceCompany.Get";
    public static final String FILTERED_BY_AMOUNT = "InsuranceCompany.Filtered_By_Amount";
    public static final String FILTERED_BY_FRANCHISE = "InsuranceCompany.Filtered_By_Franchise";


    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "description", nullable = false)
    @NotEmpty
    private String description;

    @Column(name = "franchise", nullable = false)
    @NotNull
    private int franchise;

    @Column(name = "amount", nullable = false)
    @NotNull
    private int amount;

    public InsuranceCompany() {
    }

    public InsuranceCompany(String name, String description, int franchise, int amount) {
        this(null,name,description,franchise,amount);
    }

    public InsuranceCompany(Integer id, String name, String description, int franchise, int amount) {
        super(id);
        this.name = name;
        this.description = description;
        this.franchise = franchise;
        this.amount = amount;
    }

    public Integer getId(){return id;}

    public void setId(Integer id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFranchise() {
        return franchise;
    }

    public void setFranchise(int franchise) {
        this.franchise = franchise;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", franchise=" + franchise +
                ", amount=" + amount +
                '}';
    }
}
