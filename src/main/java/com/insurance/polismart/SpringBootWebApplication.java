package com.insurance.polismart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

import static com.insurance.polismart.Profiles.ACTIVE_PROFILE;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootWebApplication {
    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, ACTIVE_PROFILE);
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
