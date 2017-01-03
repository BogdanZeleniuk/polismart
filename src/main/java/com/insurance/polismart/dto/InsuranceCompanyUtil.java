package com.insurance.polismart.dto;

import com.insurance.polismart.model.InsuranceCompany;

import java.util.List;
import java.util.stream.Collectors;

public class InsuranceCompanyUtil {

    public static List<InsuranceCompanyDTO> getInsuranceCompanyDTOFromInsuranceCompany (List<InsuranceCompany> companies) {
        return companies.stream().map(InsuranceCompanyUtil::createInsuranceCompanyDTO).collect(Collectors.toList());
    }

    public static InsuranceCompanyDTO createInsuranceCompanyDTO(InsuranceCompany company) {
        return new InsuranceCompanyDTO(company.getId(), company.getContent(),
                company.getName(), company.getDescription(), company.getFranchise(),
                company.getPopulation(), company.getEngine_power(), company.getAmount());
    }

    public static InsuranceCompany createNewInsuranceCompanyFromDTO(InsuranceCompanyDTO newCompany) {
        return new InsuranceCompany(null, newCompany.getContent(),
                newCompany.getName(), newCompany.getDescription(), newCompany.getFranchise(),
                newCompany.getPopulation(), newCompany.getEngine_power(), newCompany.getAmount());
    }
}
