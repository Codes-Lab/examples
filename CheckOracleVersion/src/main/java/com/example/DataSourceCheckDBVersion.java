////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 24.02.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.example;

/**
 *
 */

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceCheckDBVersion {
    static String DB_URL = "jdbc:oracle:oci:@//localhost:1521/serviceName";
    static String DB_USER = "user";
    static String DB_PASSWORD = "password";

    public static void main(String args[]) throws SQLException {
        if (args.length == 3) {
            DB_URL = args[0];
            DB_USER = args[1];
            DB_PASSWORD = args[1];
        }
        Properties info = new Properties();
        info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
        info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
        info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

        final OracleDataSource ods = new OracleDataSource();
        ods.setURL(DB_URL);
        ods.setConnectionProperties(info);

        // With AutoCloseable, the connection is closed automatically.
        try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
            // Get the JDBC driver name and version
            final DatabaseMetaData dbmd = connection.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("DB Major Version: " + dbmd.getDatabaseMajorVersion());
            System.out.println("Database Username is: " + connection.getUserName());
            System.out.println("JDBC major version is: " + dbmd.getJDBCMajorVersion());
        }
    }

}