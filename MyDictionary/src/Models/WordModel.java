/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exceptions.WordException;
import ObjectInfos.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class WordModel {

    private final Connection connection; // Create connection
    private PreparedStatement preparedStatement; // Create preparedStatement
    private String sql; // Create sql
    private ResultSet resultSet;// Create resultSet
    private final ArrayList<Word> words;// Create array words

    /**
     * Constructor for WordModel
     *
     * @param connection connection
     */
    public WordModel(Connection connection) {
        this.connection = connection; // Get connection
        preparedStatement = null; // Initialize preparedStatement
        sql = "";// Initialize sql
        resultSet = null;// Initialize resultSet
        words = new ArrayList<>(); // Initialize words
    }

    /**
     * Load word from database to array list
     *
     * @throws SQLException
     * @throws WordException
     */
    public void load() throws SQLException, WordException {
        sql = "SELECT * FROM `word`";// SQL select all
        preparedStatement = connection.prepareStatement(sql); // Prepare statement
        resultSet = preparedStatement.executeQuery();// Execute query

        while (resultSet.next()) {
            int id = resultSet.getInt("word_id");   // Get word id
            String text = resultSet.getString("word_text"); // Get word text
            words.add(new Word(id, text));// Add to array list
        }
    }

    /**
     * Insert word
     *
     * @param newText text
     * @return success or error
     */
    public String insert(String newText) {
        try {
            sql = "INSERT INTO `word`(`word_text`) VALUES (?)"; // sql insert
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setString(1, newText);// Set text
            preparedStatement.execute();// Execute query
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();// Show error
        }
    }

    /**
     * Delete word
     *
     * @param id id of word
     * @return success or error
     */
    public String delete(int id) {
        try {
            sql = "DELETE FROM `word` WHERE `word_id`=?"; // sql delete
            preparedStatement = connection.prepareStatement(sql);// Prepare statement
            preparedStatement.setInt(1, id);// Set id
            preparedStatement.execute();// Execute query
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();// Show error
        }
    }

    /**
     * Update word
     *
     * @param id id of word
     * @param newText text
     * @return success or error
     */
    public String update(int id, String newText) {
        try {
            sql = "UPDATE `word` SET `word_text`=? WHERE `word_id`=?";
            preparedStatement = connection.prepareStatement(sql);// Prepare statement
            preparedStatement.setString(1, newText); // Set text
            preparedStatement.setInt(2, id);    // Set id
            preparedStatement.execute(); // Execute query
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
        String str = "";// Set empty string
        int no = 0;// no
        for (Word w : words) {
            str += "#" + (++no) + ". " + w.getText() + "\n";// Show result
        }
        return str;// return str
    }

}
