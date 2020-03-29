/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exceptions.WordException;
import ObjectInfos.Meaning;
import ObjectInfos.Type;
import ObjectInfos.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

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

    private ArrayList<Word> result = null;   // Create array list result
    private TypeModel tm = null; // Create array list tm
    private MeaningModel mm = null;// Create array list mm
    private ArrayList<String> dict = null;   // Create array list dict
    private ArrayList<Word> test = null;   // Create array list test
    private static Random rand;   // Create new random

    /**
     * Constructor for WordModel
     *
     * @param connection connection
     * @param tm type model
     * @param mm meaning model
     */
    public WordModel(Connection connection, TypeModel tm, MeaningModel mm) {
        this.connection = connection; // Get connection
        preparedStatement = null; // Initialize preparedStatement
        sql = "";// Initialize sql
        resultSet = null;// Initialize resultSet
        words = new ArrayList<>(); // Initialize words

        this.tm = tm;   // Get type model
        this.mm = mm;   // Get meaning model
        result = new ArrayList<>(); // Initialize result
        test = new ArrayList<>(); // Initialize test
        rand = new Random(); // Initialize random
    }

    /**
     * Load word from database to array list
     *
     * @throws SQLException
     * @throws WordException
     */
    public void load() throws SQLException, WordException {
        sql = "SELECT * FROM `word` ORDER BY `word_text` ASC";// SQL select all
        preparedStatement = connection.prepareStatement(sql); // Prepare statement
        resultSet = preparedStatement.executeQuery();// Execute query

        words.clear();  // Clear words
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
     * @throws Exceptions.WordException
     */
    public String insert(String newText) throws WordException {
        try {
            sql = "INSERT INTO `word`(`word_text`) VALUES (?)"; // sql insert
            preparedStatement = connection.prepareStatement(sql); // Prepare statement
            preparedStatement.setString(1, newText);// Set text
            preparedStatement.execute();// Execute query
            this.load(); // Reload database

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
     * @throws Exceptions.WordException
     */
    public String delete(int id) throws WordException {
        try {
            sql = "DELETE FROM `word` WHERE `word_id`=?"; // sql delete
            preparedStatement = connection.prepareStatement(sql);// Prepare statement
            preparedStatement.setInt(1, id);// Set id
            preparedStatement.execute();// Execute query
            this.load(); // Reload database

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
     * @throws Exceptions.WordException
     */
    public String update(int id, String newText) throws WordException {
        try {
            sql = "UPDATE `word` SET `word_text`=? WHERE `word_id`=?";
            preparedStatement = connection.prepareStatement(sql);// Prepare statement
            preparedStatement.setString(1, newText); // Set text
            preparedStatement.setInt(2, id);    // Set id
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
        String str = "";// Set empty string
        int no = 0;// no
        for (Word w : words) {
            str += "#" + (++no) + ". " + w.getText() + "\n";// Show result
        }
        return str;// return str
    }

    /**
     * Check word is exist or not
     *
     * @param id id of word
     * @return true or false
     */
    public boolean isWordExit(int id) {
        return searchById(id) != null;
    }

    /**
     * Search word is exist or not with id of word
     *
     * @param id id of word
     * @return word object
     */
    public Word searchById(int id) {
        for (Word w : words) {
            if (w.getId() == id) {   // If id equal to id
                return w;   // Then return w
            }
        }
        return null;    // Otherwise return null
    }

    /**
     * Search word is exist or not with full word
     *
     * @param text text of word
     * @return word object
     */
    public Word searchByFullWord(String text) {
        for (Word w : words) {
            if (w.getText().equals(text)) { // If text equal to text
                return w; // Then return w
            }
        }
        return null;  // Otherwise return null
    }

    /**
     * Gets size of word
     *
     * @return size of word
     */
    public int getSize() {
        return words.size();
    }

    /**
     * Search word with input from user
     *
     * @param text text of input
     * @return list of result
     */
    public ArrayList<Word> search(String text) {
        result.clear(); // Clear result

        for (Word w : words) {
            // If word equal to start with text of input
            if (w.getText().toLowerCase().startsWith(text.toLowerCase())) {
                result.add(w); // Then add it to array list
            }
        }
        return result;  // Return result
    }

    /**
     * Displays a word with beautiful format HTML formatted
     *
     * @param wordID id of word
     * @return word
     */
    public String showWord(int wordID) {
        String html = ""; // Create html
        Word word = searchById(wordID); // Search word with id
        ArrayList<Meaning> meanings = mm.getMeanings(wordID);   // Store meaning

        // Show the word
        html += "<h1><font color='ff0000'>" + word.getText() + "</font></h1>";

        // Show meanings
        for (Meaning m : meanings) {
            // Show type
            int typeID = m.getTypeID(); // Get type id
            Type type = tm.searchById(typeID);  // Get type
            String text = type.getText();   // Get text

            html += "<h2><i><font color='#0000ff'> [" + text + "]</font></i></h2>";
            html += "<blockquote>" + m.getMeaning() + "</blockquote><br/>";  // Show meaning
        }
        return html; // return word
    }

    /**
     * Show dictionary
     *
     * @return list of word
     */
    public ArrayList<String> showDictionary() {
        String newWord = "";  // Store new word
        String oldWord = " "; // Store old word

        dict = new ArrayList<>(); // Init dict
        for (Word w : words) {
            newWord = w.getText(); // Get new word 
            if (oldWord.charAt(0) != newWord.charAt(0)) { // If first character of oldWord not equal to first character of newWord
                dict.add("--------------- " + newWord.toUpperCase().charAt(0) + " ---------------"); // Add it to array list
            }

            dict.add(newWord);  // Add newWord to array list
            oldWord = newWord;  // Update old word
        }

        return dict; // Return list of dict
    }

    /**
     * Displays meaning only HTML formatted
     *
     * @param wordID id of word
     * @return word
     */
    public String showMeaningOnly(int wordID) {
        String html = ""; // Create html
        ArrayList<Meaning> meanings = mm.getMeanings(wordID);   // Store meaning

        // Show meanings
        for (Meaning m : meanings) {
            // Show type
            int typeID = m.getTypeID(); // Get type id
            Type type = tm.searchById(typeID);  // Get type
            String text = type.getText();   // Get text

            html += "<h2><i><font color='#0000ff'> [" + text + "]</font></i></h2>";
            html += "<blockquote>" + m.getMeaning() + "</blockquote><br/>";  // Show meaning
        }
        return html; // return word
    }

    /**
     * Check word is correct or not
     *
     * @param wordID of of word
     * @param text text of input
     * @return true or false
     */
    public boolean isWordCorrect(int wordID, String text) {
        return searchById(wordID).isCorrect(text);
    }

    /**
     * Random number
     *
     * @param m m
     * @param n n
     * @return number
     */
    public static int random(int m, int n) {
        return m + rand.nextInt(n - m + 1);
    }

    /**
     * Generate test
     *
     * @param num number of test
     * @param isShuffle shuffle or not
     * @return list of word
     */
    public ArrayList<Word> generateTest(int num, boolean isShuffle) {
        test.clear(); // Clear array
        int[] indexies = new int[words.size()]; // Create array indexies

        for (int i = 0; i < words.size(); i++) {
            indexies[i] = i; // Assign i to indexies array
        }

        if (isShuffle) { // If shuffle 
            int j, tmp; // Create variable
            for (int i = 0; i < words.size(); i++) {
                j = random(0, words.size() - 1); // Get random value

                // Swap value
                tmp = indexies[i];
                indexies[i] = indexies[j];
                indexies[j] = tmp;
            }
        }

        for (int i = 0; i < num; i++) {
            int index = indexies[i]; // Get index
            Word word = words.get(index);
            test.add(word); // add word to array list
        }
        return test; // Return test list
    }

}
