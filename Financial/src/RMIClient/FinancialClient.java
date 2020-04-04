/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIClient;

import RMIServer.IModels.I_AccountModel;
import RMIServer.ObjectInfos.Account;
import RMIServer.ObjectInfos.Pocket;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import RMIServer.IModels.I_PocketModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tangminhtin
 */
public class FinancialClient {

//    /**
//     * FinancialClient
//     *
//     * @param args
//     * @throws RemoteException
//     * @throws NotBoundException
//     * @throws MalformedURLException
//     * @throws java.text.ParseException
//     */
//    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ParseException {
//        System.out.println("FINANCIAL MANAGEMENT SYSTEM");
//        I_AccountModel am = (I_AccountModel) Naming.lookup("rmi://localhost:3223/accountServer"); // lookup account server
//        I_PocketModel pm = (I_PocketModel) Naming.lookup("rmi://localhost:3223/pocketServer"); // lookup pocket server
//
//        am.load(); // load account
//        pm.load(); // load pocket
//
//        System.err.println("List of account: ");
//        ArrayList<Account> accounts = am.getAll(); // get all account
//        int i = 0;
//        for (Account acc : accounts) {
//            i++;
//            System.out.println(i + ". " + acc);
//        }
//
//        String username = "vinh";
//        String password = "123456";
//
//        // Get date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date fromDate = sdf.parse("2020-03-31");
//        Date toDate = sdf.parse("2020-04-03");
//
//        int aId = am.login(username, password);
//        if (aId == -1) {
//            System.out.println("Login failed");
//        } else {
//            // check login
//            System.err.println("Login successfull!");
//            Account acc = am.searchById(aId);
//            System.out.println(acc);
//
//            // check search pocket
//            System.out.println("List of search pocket: ");
//            ArrayList<Pocket> list = pm.search(aId, fromDate, toDate);
//            for (Pocket p : list) {
//                System.out.println(p);
//            }
//
//            // check income, outcome, total
//            System.out.println("Income: " + pm.income(aId, fromDate, toDate));
//            System.out.println("Outcome: " + pm.outcome(aId, fromDate, toDate));
//            System.out.println("Total: " + pm.total(aId, fromDate, toDate));
//        }
//    }
}
