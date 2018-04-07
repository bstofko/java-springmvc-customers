/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment1.util;

import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    // JDBC driver name and database URL - should store in properties file

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/clients?useSSL=false";

    //  Database credentials
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    private static Connection createConnection() {
        Logger logger = Logger.getLogger(DatabaseConnection.class);
        Connection connection = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open the connection
            logger.info("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            logger.info("Database connection successful...");

        } catch (Exception e) {
            //Handle errors for Class.forName
            logger.error("Connection Failed!...");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return createConnection();
    }
}
