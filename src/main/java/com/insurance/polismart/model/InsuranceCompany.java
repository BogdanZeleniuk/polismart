package com.insurance.polismart.model;

/**
 * Created by Admin on 29.06.2016.
 */
public class InsuranceCompany extends BaseEntity{

    private String name;
    private String description;
    private int franchise;
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
