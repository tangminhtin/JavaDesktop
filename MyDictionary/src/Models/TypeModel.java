/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exceptions.TypeException;
import ObjectInfos.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class TypeModel {

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
     */
    public TypeModel(Connection connection) {
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
     */
    public void load() throws SQLException, TypeException {
        sql = "SELECT * FROM `type`"; // SQL select all
        preparedStatement = connection.prepareStatement(sql); // Prepare statement
        resultSet = preparedStatement.executeQuery(); // Execute query

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
     * @throws Exceptions.TypeException
     */
    public String insert(String newText) throws TypeException {
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
     * @throws Exceptions.TypeException
     */
    public String delete(int id) throws TypeException {
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
     * @throws Exceptions.TypeException
     */
    public String update(int id, String newText) throws TypeException {
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
     */
    public int getSize() {
        return types.size();
    }

    /**
     * Search type is exist or not with id of type
     *
     * @param id id of type
     * @return type object
     */
    public Type searchById(int id) {
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
     */
    public boolean isTypeExist(int typeID) {
        return searchById(typeID) != null;
    }

    /**
     * Gets type list
     *
     * @return list of types
     */
    public ArrayList<String> getTypeList() {
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
     */
    public Type searchByName(String text) {
        for (Type t : types) {
            if (t.getText().equals(text)) { // If text equal to text
                return t; // Then return t
            }
        }
        return null;  // Otherwise return null
    }

}
