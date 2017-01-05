package com.insurance.polismart.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.util.Properties;

import static com.insurance.polismart.Profiles.*;

@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.insurance.polismart.model");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }


    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "");
        properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL81Dialect");
        return properties;
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    @Profile({MONGODB,DATAMONGODB})
    public Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    @Profile({MONGODB,DATAMONGODB})
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new Mongo(), "polismart");
    }

    @Bean
    @Profile({MONGODB,DATAMONGODB})
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "polismart");
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/polismart");
        dataSource.setUsername( "postgres" );
        dataSource.setPassword( "password" );
        return dataSource;
    }

    @Bean(name = "messageSource")
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("schema.sql"));
        databasePopulator.addScript(new ClassPathResource("data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(true);
        return dataSourceInitializer;
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    @Bean
    @Profile({ACTIVE_DB, ACTIVE_REPOSITORY})
    public static PropertyPlaceholderConfigurer placeHolderConfigurer(){
        final PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
        props.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE );
        return props;
    }
}
