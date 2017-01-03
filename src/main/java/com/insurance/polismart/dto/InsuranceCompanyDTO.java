package com.insurance.polismart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class InsuranceCompanyDTO {

    private Integer id;

    private byte[] content;

    @NotEmpty(message = "Name could not be empty")
    @NotNull(message = "Name could not be empty")
    private String name;

    @NotEmpty(message = "Description could not be empty")
    @NotNull(message = "Description could not be empty")
    private String description;

    @NotNull(message = "Franchise could not be empty")
    @Range(min = 0, max = 5000, message = "Franchise could be between 0 and 5000")
    private int franchise;

    @NotNull(message = "Population could not be empty")
    private String population;

    @NotNull(message = "Engine power could not be empty")
    private String engine_power;

    @NotNull(message = "Amount could not be empty")
    @Range(min = 0, max = Integer.MAX_VALUE, message = "Amount must be more than 0")
    private int amount;

    public InsuranceCompanyDTO() {
    }

    public InsuranceCompanyDTO(@JsonProperty("id") Integer id,
                               @JsonProperty("content") byte [] content,
                               @JsonProperty("name") String name,
                               @JsonProperty("description") String description,
                               @JsonProperty("franchise") int franchise,
                               @JsonProperty("population") String population,
                               @JsonProperty("engine_power") String engine_power,
                               @JsonProperty("amount") int amount) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.description = description;
        this.franchise = franchise;
        this.population = population;
        this.engine_power = engine_power;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFranchise() {
        return franchise;
    }

    public int getAmount() {
        return amount;
    }

    public byte[] getContent() {
        return content;
    }

    public String getPopulation() {
        return population;
    }

    public String getEngine_power() {
        return engine_power;
    }

    @Override
    public String toString() {
        return "InsuranceCompanyDTO{" +
                "id=" + id +
                ", content=" + Arrays.toString(content) +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", franchise=" + franchise +
                ", population='" + population + '\'' +
                ", engine_power='" + engine_power + '\'' +
                ", amount=" + amount +
                '}';
    }
}
