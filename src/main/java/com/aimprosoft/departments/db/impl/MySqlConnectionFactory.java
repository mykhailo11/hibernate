package com.aimprosoft.departments.db.impl;

import com.aimprosoft.departments.db.ConnectionFactory;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlConnectionFactory implements ConnectionFactory {

    private final Driver mySqlDriver;
    private static MySqlConnectionFactory factory;

    private MySqlConnectionFactory() throws SQLException {
        mySqlDriver = new Driver();
    }

    public static MySqlConnectionFactory getFactory() throws SQLException {
        if (factory == null) {
            factory = new MySqlConnectionFactory();
        }
        return factory;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return mySqlDriver.connect(ConnectionPropertiesProvider.getUrl(),
                ConnectionPropertiesProvider.getProperties());
    }
}
