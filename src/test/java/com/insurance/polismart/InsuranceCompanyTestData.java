package com.insurance.polismart;

import com.insurance.polismart.model.InsuranceCompany;

import java.util.Arrays;
import java.util.List;

public class InsuranceCompanyTestData {
    public static final InsuranceCompany COMPANY_ONE = new InsuranceCompany(3, null,"INGO Ukraine","The best Russian insurance company",0,"Kiev","to 1.6",1037);
    public static final InsuranceCompany COMPANY_TWO = new InsuranceCompany(4, null, "PZU Ukraine","The best Polish insurance company",0,"Kiev","to 1.6",1037);
    public static final InsuranceCompany COMPANY_THREE = new InsuranceCompany(5, null, "UNIVES","The best Ukrainian insurance company",0,"Kiev","to 1.6",798);
    public static final InsuranceCompany COMPANY_FOUR = new InsuranceCompany(6, null, "AXA","The best French insurance company",0,"Kiev","to 1.6",1296);
    public static final InsuranceCompany COMPANY_FIVE = new InsuranceCompany(7, null, "TALISMAN","The worse Ukrainian insurance company",0,"Kiev","to 1.6",695);
    public static final InsuranceCompany COMPANY_SIX = new InsuranceCompany(8, null, "GRAWE","The best Austrian insurance company",0,"Kiev","to 1.6",1102);

    public static final List<InsuranceCompany> COMPANIES = Arrays.asList(COMPANY_FOUR, COMPANY_SIX, COMPANY_ONE, COMPANY_TWO,COMPANY_THREE,COMPANY_FIVE);
    public static final List<InsuranceCompany> COMPANIES_WITH_ORDER = Arrays.asList(COMPANY_ONE, COMPANY_TWO, COMPANY_THREE, COMPANY_FOUR,COMPANY_FIVE,COMPANY_SIX);
    public static final List<InsuranceCompany> COMPANIES_WITH_JDBC = Arrays.asList(COMPANY_FIVE,COMPANY_THREE,COMPANY_ONE,COMPANY_TWO,COMPANY_SIX,COMPANY_FOUR);
}
