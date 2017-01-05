package com.insurance.polismart;

public class Profiles {
    public static final String

        JDBC = "jdbc",
        DATAJPA = "datajpa",
        DATAMONGODB = "datamongodb",
        JPA = "jpa",
        POSTGRESQL = "postgresql",
        MONGODB = "mongodb";

    public static final String ACTIVE_REPOSITORY = JPA;
    public static final String ACTIVE_DB = POSTGRESQL;
    public static final String ACTIVE_PROFILE = ACTIVE_REPOSITORY+","+ACTIVE_DB;
    public static final String ACTIVE_PROFILE_MONGODB = DATAMONGODB+","+MONGODB;


}
