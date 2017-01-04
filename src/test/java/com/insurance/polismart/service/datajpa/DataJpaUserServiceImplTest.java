package com.insurance.polismart.service.datajpa;

import com.insurance.polismart.service.UserServiceImplTest;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.DATAJPA;

@ActiveProfiles({DATAJPA,ACTIVE_DB})
public class DataJpaUserServiceImplTest extends UserServiceImplTest{
}
