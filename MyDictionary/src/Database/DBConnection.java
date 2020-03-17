/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class DBConnection {

    private final String URL = "jdbc:mysql://localhost:3306/ce130438";  // Store database
    private final String USER = "root"; // Store user
    private final String PWD = ""; // Store password
    Connection connection = null;  // Create connection

    /**
     * Create new connection to Database Server
     *
     * @throws SQLException
     */
    public DBConnection() throws SQLException {
        // Use com.mysql.jdbc.Driver() to connect to MySQL Server
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // Connect to MySQL Server base on URL, USER and PWD
        connection = (Connection) DriverManager.getConnection(URL, USER, PWD);

    }

    /**
     * Gets connection
     *
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Check status of connection
     *
     * @return true or false
     */
    public boolean isConnected() {
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
