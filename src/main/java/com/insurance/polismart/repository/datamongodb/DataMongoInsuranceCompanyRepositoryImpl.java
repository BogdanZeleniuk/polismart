package com.insurance.polismart.repository.datamongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static com.insurance.polismart.Profiles.DATAMONGODB;

@Repository
@Profile(DATAMONGODB)
public class DataMongoInsuranceCompanyRepositoryImpl {
}
