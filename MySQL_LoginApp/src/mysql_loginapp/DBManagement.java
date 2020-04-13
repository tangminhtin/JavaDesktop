/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class DBManagement {

    private final String URL = "jdbc:mysql://localhost:3306/aaaaaa";  // Store database
    private final String UID = "root";  // Store user
    private final String PWD = "";      // Store password
    private Connection connection = null;   // Create connection

    /**
     * Create new connection to Database Server
     *
     * @throws SQLException
     */
    public DBManagement() throws SQLException {
        // Use com.mysql.jdbc.Driver() to connect to MySQL Server
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // Connect to MySQL Server base on URL, UID and PWD
        connection = (Connection) DriverManager.getConnection(URL, UID, PWD);
    }

    /**
     * Gets connection
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Check status of connection
     *
     * @return
     */
    public boolean isConnection() {
        return connection != null;
    }

    /**
     * Close connection
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
