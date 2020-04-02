/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class DBManagement {

    private final String URL = "jdbc:mysql://localhost:3306/ce130438";
    private final String USER = "root";
    private final String PWD = "";
    private Connection connection = null;

    /**
     *
     * @throws SQLException
     */
    public DBManagement() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = (Connection) DriverManager.getConnection(URL, USER, PWD);
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     *
     * @return
     */
    public boolean isConnection() {
        return connection != null;
    }

    /**
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
