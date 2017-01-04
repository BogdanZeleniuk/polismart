package com.insurance.polismart.repository.jpa;

import com.insurance.polismart.repository.InsuranceCompanyRepositoryImplTest;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.JPA;

@ActiveProfiles({JPA,ACTIVE_DB})
public class JpaInsuranceCompanyRepositoryImpTest extends InsuranceCompanyRepositoryImplTest{
}
