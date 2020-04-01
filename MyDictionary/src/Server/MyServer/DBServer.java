/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.MyServer;

import Server.Database.DBConnection;
import Server.Exceptions.MeaningException;
import Server.Exceptions.TypeException;
import Server.Models.MeaningModel;
import Server.Models.TypeModel;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tangminhtin
 */
public class DBServer {

    /**
     *
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws SQLException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, SQLException, TypeException, MeaningException {
        DBConnection db = new DBConnection();   // Create new db
        Connection connection = db.getConnection();// Get connection
        TypeModel tm = new TypeModel(connection);   // Create tm
        MeaningModel mm = new MeaningModel(connection); // Create tm

        LocateRegistry.createRegistry(3223);    // Create Registry
        Naming.rebind("rmi://localhost:3223/typeServer", new Server.Models.TypeModel(connection)); // type server
        Naming.rebind("rmi://localhost:3223/meaningServer", new Server.Models.MeaningModel(connection)); // meaning server
        Naming.rebind("rmi://localhost:3223/wordServer", new Server.Models.WordModel(connection, tm, mm)); // word server
        System.out.println("Type Server is running...");
        System.out.println("Meaning Server is running...");
        System.out.println("Word Server is running...");
    }

}
