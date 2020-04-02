/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.Application;

import RMIServer.Database.DBManagement;
import RMIServer.Models.AccountModel;
import RMIServer.Models.PocketModel;
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
public class FinancialServer {

    private static DBManagement db; // create db
    private static Connection connection; // create connection

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            db = new DBManagement(); // initialize db
            connection = db.getConnection(); // get connection
            LocateRegistry.createRegistry(3223); // create registry
            Naming.rebind("rmi://localhost:3223/accountServer", new AccountModel(connection)); // create server
            Naming.rebind("rmi://localhost:3223/pocketServer", new PocketModel(connection)); // create server

            System.out.println("Financial Server is running...");
        } catch (MalformedURLException | RemoteException | SQLException e) {
            System.err.println(e);
        }
    }
}
