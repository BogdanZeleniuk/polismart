package com.insurance.polismart.repository.datajpa;

import com.insurance.polismart.repository.UserRepositoryImplTest;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.DATAJPA;

@ActiveProfiles({DATAJPA,ACTIVE_DB})
public class DataJpaUserRepositoryImpTest extends UserRepositoryImplTest{
}
