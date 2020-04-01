/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Models;

import Server.Exceptions.TypeException;
import Server.MyServer.I_TypeModel;
import Server.ObjectInfos.Type;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class TypeModel extends UnicastRemoteObject implements I_TypeModel {

    private final Connection connection;  // Create connection
    private PreparedStatement preparedStatement; // Create preparedStatement
    private String sql; // Create sql
    private ResultSet resultSet;// Create resultSet
    private final ArrayList<Type> types; // Create array types

    private ArrayList<String> result = null; // Create array result

    /**
     * Constructor for TypeModel
     *
     * @param connection connection
     * @throws java.rmi.RemoteException
     */
    public TypeModel(Connection connection) throws RemoteException {
        super();
        this.connection = connection; // Get connection
        preparedStatement = null;// Initialize preparedStatement
        sql = ""; // Initialize sql
        resultSet = null; // Initialize resultSet
        types = new ArrayList<>();// Initialize meanings

        result = new ArrayList<>(); // Initialize result
    }

    /**
     * Load type from database to array list
     *
     * @throws SQLException
     * @throws TypeException
     * @throws java.rmi.RemoteException
     */
    @Override
    public void load() throws SQLException, TypeException, RemoteException {
        sql = "SELECT * FROM `type`"; // SQL select all
        preparedStatement = connection.prepareStatement(sql); // Prepare statement
        resultSet = preparedStatement.executeQuery(); // Execute query
        types.clear();  // Clear types

        while (resultSet.next()) {
            int id = resultSet.getInt("type_id");// Get type id
            String text = resultSet.getString("type_text");// Get type text
            types.add(new Type(id, text));// Add to array list
        }
    }

    /**
     * Insert type
     *
     * @param newText text
     * @return success or error
     * @throws Server.Exceptions.TypeException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String insert(String newText) throws TypeException, RemoteException {
        try {
            sql = "INSERT INTO `type`(`type_text`) VALUES (?)"; // sql insert
            preparedStatement = connection.prepareCall(sql);// Prepare statement
            preparedStatement.setString(1, newText);    // Set new text
            preparedStatement.execute();  // Execute query
            this.load(); // Reload database

            return "Success";
        } catch (SQLException e) {
            return e.getMessage();// Show error
        }
    }

    /**
     * Delete type
     *
     * @param id id of type
     * @return success or error
     * @throws Server.Exceptions.TypeException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String delete(int id) throws TypeException, RemoteException {
        try {
            sql = "DELETE FROM `type` WHERE `type_id`=?"; // sql delete
            preparedStatement = connection.prepareStatement(sql);// Prepare statement
            preparedStatement.setInt(1, id);   // Set id of type
            preparedStatement.execute();// Execute query
            this.load(); // Reload database

            return "Success";
        } catch (SQLException e) {
            return e.getMessage();// Show error
        }
    }

    /**
     * Update type
     *
     * @param id id of type
     * @param newText text
     * @return success or error
     * @throws Server.Exceptions.TypeException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String update(int id, String newText) throws TypeException, RemoteException {
        try {
            sql = "UPDATE `type` SET `type_text`=? WHERE `type_id`=?"; // sql update
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setString(1, newText);    // Set text
            preparedStatement.setInt(2, id);    // Set id of type
            preparedStatement.execute(); // Execute query
            this.load(); // Reload database

            return "Success";
        } catch (SQLException e) {
            return e.getMessage();// Show error
        }
    }

    /**
     * Override method toString()
     *
     * @return list of result
     */
    @Override
    public String toString() {
        String str = ""; // Set empty string
        int no = 0; // no
        for (Type t : types) {
            str += "#" + (++no) + ". " + t.getText() + "\n";// Show result
        }
        return str; // return str
    }

    /**
     * Gets size of type
     *
     * @return size of type
     * @throws java.rmi.RemoteException
     */
    @Override
    public int getSize() throws RemoteException {
        return types.size();
    }

    /**
     * Search type is exist or not with id of type
     *
     * @param id id of type
     * @return type object
     * @throws java.rmi.RemoteException
     */
    @Override
    public Type searchById(int id) throws RemoteException {
        for (Type t : types) {
            if (t.getId() == id) {   // If id equal to id
                return t;   // Then return t
            }
        }
        return null;    // Otherwise return null
    }

    /**
     * Check type is exist or not
     *
     * @param typeID id of type
     * @return true or false
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean isTypeExist(int typeID) throws RemoteException {
        return searchById(typeID) != null;
    }

    /**
     * Gets type list
     *
     * @return list of types
     * @throws java.rmi.RemoteException
     */
    @Override
    public ArrayList<String> getTypeList() throws RemoteException {
        result.clear();     // Clear array
        for (Type t : types) {
            result.add(t.getText());    // Add type to array list
        }
        return result;
    }

    /**
     * Search type is exist or not with name
     *
     * @param text text of word
     * @return type object
     * @throws java.rmi.RemoteException
     */
    @Override
    public Type searchByName(String text) throws RemoteException {
        for (Type t : types) {
            if (t.getText().equals(text)) { // If text equal to text
                return t; // Then return t
            }
        }
        return null;  // Otherwise return null
    }

}
