package com.aimprosoft.departments.db;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection getConnection() throws Exception;
}
