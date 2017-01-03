package com.insurance.polismart.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@NamedQueries(
        {
                @NamedQuery(name = InsuranceCompany.GET_All, query = "SELECT company FROM InsuranceCompany company ORDER BY company.amount DESC"),
                @NamedQuery(name = InsuranceCompany.DELETE, query = "DELETE FROM InsuranceCompany company WHERE company.id=:id"),
                @NamedQuery(name = InsuranceCompany.GET, query = "SELECT company FROM InsuranceCompany company WHERE company.id=:id"),
                @NamedQuery(name = InsuranceCompany.FILTERED_BY_DATA, query = "SELECT company FROM InsuranceCompany company WHERE " +
                        "company.amount BETWEEN :minAmount AND :maxAmount AND company.franchise BETWEEN :minFranchise AND :maxFranchise " +
                        "AND company.population=:population AND company.engine_power=:engine_power ORDER BY company.amount DESC")
        }
)
@Entity
@Table(name = "insurance_companies")
public class InsuranceCompany extends BaseEntity{

    public static final String GET_All = "InsuranceCompany.GET_All";
    public static final String DELETE = "InsuranceCompany.DELETE";
    public static final String GET = "InsuranceCompany.GET";
    public static final String FILTERED_BY_DATA = "InsuranceCompany.FILTERED_BY_DATA";

    @Column(name = "content", nullable=false)
    private byte[] content;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Name could not be empty")
    @NotNull(message = "Name could not be empty")
    private String name;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "Description could not be empty")
    @NotNull(message = "Description could not be empty")
    private String description;

    @Column(name = "franchise", nullable = false)
    @NotNull(message = "Franchise could not be empty")
    @Range(min = 0, max = 5000, message = "Franchise could be between 0 and 5000")
    private int franchise;

    @Column(name = "population", nullable = false)
    @NotNull(message = "Population could not be empty")
    private String population;

    @Column(name = "engine_power", nullable = false)
    @NotNull(message = "Engine power could not be empty")
    private String engine_power;

    @Column(name = "amount", nullable = false)
    @NotNull(message = "Amount could not be empty")
    @Range(min = 0, max = Integer.MAX_VALUE, message = "Amount must be more than 0")
    private int amount;

    public InsuranceCompany() {
    }

    public InsuranceCompany(byte[] content, String name, String description, int franchise, String population, String engine_power, int amount) {
        this(null,content,name,description,franchise,population,engine_power,amount);
    }

    public InsuranceCompany(Integer id, byte[] content, String name, String description, int franchise, String population, String engine_power, int amount) {
        super(id);
        this.content = content;
        this.name = name;
        this.description = description;
        this.franchise = franchise;
        this.population = population;
        this.engine_power = engine_power;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(String engine_power) {
        this.engine_power = engine_power;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "content=" + Arrays.toString(content) +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", franchise=" + franchise +
                ", population='" + population + '\'' +
                ", engine_power='" + engine_power + '\'' +
                ", amount=" + amount +
                '}';
    }
}
