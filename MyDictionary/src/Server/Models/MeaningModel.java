/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Models;

import Server.Exceptions.MeaningException;
import Server.MyServer.I_MeaningModel;
import Server.ObjectInfos.Meaning;
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
public class MeaningModel extends UnicastRemoteObject implements I_MeaningModel {

    private final Connection connection;            // Create connection
    private PreparedStatement preparedStatement;    // Create preparedStatement
    private String sql;         // Create sql
    private ResultSet resultSet;    // Create resultSet
    private final ArrayList<Meaning> meanings; // Create array meanings

    private ArrayList<Meaning> result = null;   // Create array list result

    /**
     * Constructor for MeaningModel
     *
     * @param connection connection
     * @throws java.rmi.RemoteException
     */
    public MeaningModel(Connection connection) throws RemoteException {
        super();
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
     * @throws java.rmi.RemoteException
     */
    @Override
    public void load() throws SQLException, MeaningException, RemoteException {
        sql = "SELECT * FROM `meaning`";    // SQL select all
        preparedStatement = connection.prepareStatement(sql);   // Prepare statement
        resultSet = preparedStatement.executeQuery();   // Execute query
        meanings.clear();   // Clear meanings

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
     * @throws Server.Exceptions.MeaningException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String insert(int wordID, int typeID, String newText) throws MeaningException, RemoteException {
        try {
            sql = "INSERT INTO `meaning`(`word_id`, `type_id`, `meaning_text`) VALUES (?,?,?)"; // sql insert
            preparedStatement = connection.prepareStatement(sql);   // Prepare statement
            preparedStatement.setInt(1, wordID);    // Set word id
            preparedStatement.setInt(2, typeID);    // Set type id
            preparedStatement.setString(3, newText); // Set new text
            preparedStatement.execute(); // Execute query
            this.load(); // Reload database
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();  // Show error
        }
    }

    /**
     * Delete meaning
     *
     * @param wordID id of word
     * @return success or error
     * @throws Server.Exceptions.MeaningException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String delete(int wordID) throws MeaningException, RemoteException {
        try {
            sql = "DELETE FROM `meaning` WHERE `word_id`=?"; // sql delete
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setInt(1, wordID); // Set word id
            preparedStatement.execute();    // Execute query
            this.load(); // Reload database

            return "Success";
        } catch (SQLException e) {
            return e.getMessage(); // Show error
        }
    }

    /**
     * Update meaning
     *
     * @param wordID id of word
     * @param oldTypeID id of type
     * @param newTypeID
     * @param newText meaning
     * @return success or error
     * @throws Server.Exceptions.MeaningException
     * @throws java.rmi.RemoteException
     */
    @Override
    public String update(int wordID, int oldTypeID, int newTypeID, String newText) throws MeaningException, RemoteException {
        try {
            sql = "UPDATE `meaning` SET `type_id`=?, `meaning_text`=? WHERE `word_id`=? AND `type_id`=?"; // sql update
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setInt(1, newTypeID);    // Set type id
            preparedStatement.setString(2, newText); // Set meaning
            preparedStatement.setInt(3, wordID); // Set word id
            preparedStatement.setInt(4, oldTypeID); // Set type id
            preparedStatement.execute(); // Execute query
            this.load(); // Reload database

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

    /**
     * Gets size of meaning
     *
     * @return size of meaning
     * @throws java.rmi.RemoteException
     */
    @Override
    public int getSize() throws RemoteException {
        return meanings.size();
    }

    /**
     * Check meaning is exist or not
     *
     * @param wordID id of word
     * @param typeID id of type
     * @return true or false
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean isMeaningExist(int wordID, int typeID) throws RemoteException {
        return searchById(wordID, typeID) != null;
    }

    /**
     * Search meaning by id word, type
     *
     * @param wordID id of word
     * @param typeID id of type
     * @return meaning or null
     * @throws java.rmi.RemoteException
     */
    @Override
    public Meaning searchById(int wordID, int typeID) throws RemoteException {
        for (Meaning m : meanings) {
            // Check id word, type exist or not
            if (m.getWordID() == wordID && m.getTypeID() == typeID) {
                return m; // Return meaning
            }
        }
        return null;
    }

    /**
     * Search meaning by meaning
     *
     * @param meaning meaning of word
     * @return meaning or null
     * @throws java.rmi.RemoteException
     */
    @Override
    public Meaning searchByMeaning(String meaning) throws RemoteException {
        for (Meaning m : meanings) {
            // Check meaning is exist or not
            if (m.getMeaning().equals(meaning)) {
                return m; // Return meaning
            }
        }
        return null;
    }

    /**
     * Gets meanings of word when user type
     *
     * @param wordID id of word
     * @return list of word
     */
    public ArrayList<Meaning> getMeanings(int wordID) throws RemoteException {
        result = new ArrayList<>(); // Init array result

        for (Meaning m : meanings) {
            if (m.getWordID() == wordID) {  // If wordID equal wordID
                result.add(m);  // Then add it to array list
            }
        }
        return result;  // Return result
    }

}
