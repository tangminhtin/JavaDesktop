/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_vnnote_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class DBManagement {

    public static final String URL = "jdbc:mysql://localhost:3306/vnote2";
    public static final String UID = "root";
    public static final String PWD = "";
    private Connection connection = null;

    /**
     * Creates new connection to Database server
     */
    public DBManagement() throws SQLException {
        // Use com.mysql.jdbc.Driver() to connect to MySQL Server
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        
        // Connects to MySQL Server base on URL, UID and PWD
        this.connection = (Connection) DriverManager.getConnection(URL, UID, PWD);
        
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Checks the connection's status
     *
     * @return
     */
    public boolean isConnected() {
        return this.connection != null;
    }

    /**
     * Closes current connection
     * @throws SQLException 
     */
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
