package com.insurance.polismart.service.jpa;

import com.insurance.polismart.service.UserServiceImplTest;
import org.springframework.test.context.ActiveProfiles;

import static com.insurance.polismart.Profiles.ACTIVE_DB;
import static com.insurance.polismart.Profiles.JPA;

@ActiveProfiles({JPA,ACTIVE_DB})
public class JpaUserServiceImplTest extends UserServiceImplTest{
}
