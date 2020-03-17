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
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class MyDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MeaningException {
        try {
            DBConnection db = new DBConnection();   // Create new db
            Connection connection = db.getConnection();// Get connection

            WordModel wm = new WordModel(connection);   // Create new wm
            wm.load();// Load word model
            System.out.println("List of words:");
            System.out.println(wm);// Show word model

            TypeModel tm = new TypeModel(connection);   // Create new tm
            tm.load();// Load type model
            System.out.println("List of types:");
            System.out.println(tm); // Show type model

            MeaningModel meaningModel = new MeaningModel(connection); // Create new meaningModel
            meaningModel.load(); // Load meaningModel
            System.out.println("List of meanings:");
            System.out.println(meaningModel); // Show meaningModel

        } catch (TypeException | WordException | SQLException e) {
            System.out.println(e.getMessage()); // Show error
        }
    }

}
