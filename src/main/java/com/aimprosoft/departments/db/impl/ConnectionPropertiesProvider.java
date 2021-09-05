package com.aimprosoft.departments.db.impl;

import java.util.Properties;

public class ConnectionPropertiesProvider {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final  String PASSWORD = "0000";
    private static final Properties PROPERTIES = new Properties();
    static {
        PROPERTIES.setProperty("user", USER);
        PROPERTIES.setProperty("password", PASSWORD);
    }

    private ConnectionPropertiesProvider(){}
    public static String getUrl(){
        return URL;
    }
    public static Properties getProperties(){
        return PROPERTIES;
    }
}
