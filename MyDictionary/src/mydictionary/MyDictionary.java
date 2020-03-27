/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import Database.DBConnection;
import Exceptions.MeaningException;
import Exceptions.TypeException;
import Exceptions.WordException;
import Models.MeaningModel;
import Models.TypeModel;
import Models.WordModel;
import ObjectInfos.Word;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class MyDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DBConnection db = new DBConnection();   // Create new db
            Connection connection = db.getConnection();// Get connection

            TypeModel tm = new TypeModel(connection);   // Create new tm
            tm.load();// Load type model
            System.out.println("List of types:");
            System.out.println(tm); // Show type model

            MeaningModel mm = new MeaningModel(connection); // Create new meaningModel
            mm.load(); // Load meaningModel
            System.out.println("List of meanings:");
            System.out.println(mm); // Show meaningModel

            WordModel wm = new WordModel(connection, tm, mm);   // Create new wm
            wm.load();// Load word model
            System.out.println("List of words:");
            System.out.println(wm);// Show word model

            ArrayList<String> dict = wm.showDictionary(); // Show list of dict
            for (String w : dict) {
                System.out.println(w); // Show each word in dict
            }

            ArrayList<Word> test = wm.generateTest(4, true); // Show list of test word
            for (Word w : test) {
                System.out.println(w); // Show each word in test
            }

        } catch (TypeException | WordException | MeaningException | SQLException e) {
            System.out.println(e.getMessage()); // Show error
        }
    }

}
