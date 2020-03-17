/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exceptions.MeaningException;
import ObjectInfos.Meaning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class MeaningModel {

    private final Connection connection;            // Create connection
    private PreparedStatement preparedStatement;    // Create preparedStatement
    private String sql;         // Create sql
    private ResultSet resultSet;    // Create resultSet
    private final ArrayList<Meaning> meanings; // Create array meanings

    /**
     * Constructor for MeaningModel
     *
     * @param connection connection
     */
    public MeaningModel(Connection connection) {
        this.connection = connection; // Get connection
        preparedStatement = null;   // Initialize preparedStatement
        sql = "";   // Initialize sql
        resultSet = null; // Initialize resultSet
        meanings = new ArrayList<>(); // Initialize meanings
    }

    /**
     * Load meaning from database to array list
     *
     * @throws SQLException
     * @throws MeaningException
     */
    public void load() throws SQLException, MeaningException {
        sql = "SELECT * FROM `meaning`";    // SQL select all
        preparedStatement = connection.prepareStatement(sql);   // Prepare statement
        resultSet = preparedStatement.executeQuery();   // Execute query

        while (resultSet.next()) {
            int wordID = resultSet.getInt("word_id");   // Get word id
            int typeID = resultSet.getInt("type_id");   // Get type id
            String meaning = resultSet.getString("meaning_text");   // Get meaning of word
            meanings.add(new Meaning(wordID, typeID, meaning)); // Add to array list
        }
    }

    /**
     * Insert meaning
     *
     * @param wordID id of word
     * @param typeID id of type
     * @param newText meaning
     * @return success or error
     */
    public String insert(int wordID, int typeID, String newText) {
        try {
            sql = "INSERT INTO `meaning`(`word_id`, `type_id`, `meaning_text`) VALUES (?,?,?)"; // sql insert
            preparedStatement = connection.prepareStatement(sql);   // Prepare statement
            preparedStatement.setInt(1, wordID);    // Set word id
            preparedStatement.setInt(2, typeID);    // Set type id
            preparedStatement.setString(3, newText); // Set new text
            preparedStatement.execute(); // Execute query
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();  // Show error
        }
    }

    /**
     * Delete meaning
     *
     * @param wordID id of word
     * @param typeID id of type
     * @return success or error
     */
    public String delete(int wordID, int typeID) {
        try {
            sql = "DELETE FROM `meaning` WHERE `word_id`=? AND `type_id`=?"; // sql delete
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setInt(1, wordID); // Set word id
            preparedStatement.setInt(2, typeID); // Set type id
            preparedStatement.execute();    // Execute query
            return "Success";
        } catch (SQLException e) {
            return e.getMessage(); // Show error
        }
    }

    /**
     * Update meaning
     *
     * @param wordID id of word
     * @param typeID id of type
     * @param newText meaning
     * @return success or error
     */
    public String update(int wordID, int typeID, String newText) {
        try {
            sql = "UPDATE `meaning` SET `meaning_text`=? WHERE `word_id`=? AND `type_id`=?"; // sql update
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setString(1, newText); // Set meaning
            preparedStatement.setInt(2, wordID); // Set word id
            preparedStatement.setInt(3, typeID); // Set type id
            preparedStatement.execute(); // Execute query
            return "Success";
        } catch (SQLException e) {
            return e.getMessage(); // Show error
        }
    }

    /**
     * Override method toString()
     *
     * @return list of result
     */
    @Override
    public String toString() {
        String str = "";  // Set empty string
        int no = 0; // no
        for (Meaning m : meanings) {
            str += "#" + (++no) + ". " + m.getMeaning() + "\n"; // Show result
        }
        return str; // return str
    }

}
