/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.Models;

import RMIServer.Exceptions.AccountException;
import RMIServer.IModels.I_AccountModel;
import RMIServer.ObjectInfos.Account;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class AccountModel extends UnicastRemoteObject implements I_AccountModel {

    private Connection connection = null;   // create connection
    private PreparedStatement preparedStatement = null; // create preparedStatement
    private String sql = "";// create sql
    private ResultSet resultSet;// create resultSet

    private ArrayList<Account> accounts = null;// create array list accounts
    private ArrayList<Account> result = null;// create array list result

    /**
     * constructor AccountModel
     *
     * @param connection connection
     * @throws RemoteException RemoteException
     */
    public AccountModel(Connection connection) throws RemoteException {
        super();
        this.connection = connection; // Initialize connection
        accounts = new ArrayList<>(); // Initialize accounts
        result = new ArrayList<>(); // Initialize result
    }

    /**
     * load account
     *
     * @throws RemoteException RemoteException
     */
    @Override
    public void load() throws RemoteException {
        try {
            sql = "SELECT * FROM `account` ORDER BY `a_user` ASC"; // sql query
            preparedStatement = connection.prepareStatement(sql); // preparedStatement
            resultSet = preparedStatement.executeQuery(); // excute query
            accounts.clear();   // clear all accounts
            while (resultSet.next()) {
                int aId = resultSet.getInt("a_id"); // get id
                String user = resultSet.getString("a_user"); // get user
                String pass = resultSet.getString("a_pass");// get password
                accounts.add(new Account(aId, user, pass)); // add account to array list
            }
        } catch (SQLException | AccountException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * insert new account
     *
     * @param username username
     * @param password username
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String insert(String username, String password) throws RemoteException {
        try {
            sql = "INSERT INTO `account`(`a_user`, `a_pass`) VALUES (?, MD5(?))"; // sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setString(1, username); // set username
            preparedStatement.setString(2, password); // set password
            preparedStatement.execute();// excute query
            this.load(); // Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * delete account
     *
     * @param aId id account
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String delete(int aId) throws RemoteException {
        try {
            sql = "DELETE FROM `account` WHERE `a_id`=?";// sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setInt(1, aId);// set id account
            preparedStatement.execute();// excute query
            this.load(); // Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * update account
     *
     * @param aId id account
     * @param username username
     * @param password password
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String update(int aId, String username, String password) throws RemoteException {
        try {
            sql = "UPDATE `account` SET `a_user`=?,`a_pass`=MD5(?) WHERE `a_id`=?"; // sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setString(1, username);// set username
            preparedStatement.setString(2, password);// set password
            preparedStatement.setInt(3, aId);// set id account
            preparedStatement.execute();// excute query
            this.load();// Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * search account by id
     *
     * @param aId id account
     * @return account
     * @throws RemoteException RemoteException
     */
    @Override
    public Account searchById(int aId) throws RemoteException {
        for (Account acc : accounts) {
            if (acc.getaId() == aId) {
                return acc; // return account if exist
            }
        }
        return null;
    }

    /**
     * search account by username
     *
     * @param username username
     * @return account
     * @throws RemoteException RemoteException
     */
    @Override
    public Account searchByUsername(String username) throws RemoteException {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc; // return account if exist
            }
        }
        return null;
    }

    /**
     * search list account by username
     *
     * @param query input
     * @return list account
     * @throws RemoteException RemoteException
     */
    @Override
    public ArrayList<Account> search(String query) throws RemoteException {
        result.clear(); // clear old data
        for (Account acc : accounts) {
            if (acc.getUsername().contains(query)) {
                result.add(acc); // add acc to array list
            }
        }
        return result;
    }

    /**
     * get size
     *
     * @return @throws RemoteException RemoteException
     */
    @Override
    public int getSize() throws RemoteException {
        return this.accounts.size();
    }

    /**
     * check exist or not
     *
     * @param username username
     * @return true or false
     * @throws RemoteException
     */
    @Override
    public boolean isExist(String username) throws RemoteException {
        return this.searchByUsername(username) != null;
    }

    /**
     * login
     *
     * @param username username
     * @param password username
     * @return int
     * @throws RemoteException RemoteException
     */
    @Override
    public int login(String username, String password) throws RemoteException {
        try {
            sql = "SELECT * FROM `account` WHERE `a_user`=? AND `a_pass`=MD5(?)"; // create sql
            preparedStatement = connection.prepareStatement(sql); // preparedStatement
            preparedStatement.setString(1, username); // set username
            preparedStatement.setString(2, password); // set password
            resultSet = preparedStatement.executeQuery(); // excute query

            if (resultSet.first()) {
                int aId = resultSet.getInt("a_id");
                String user = resultSet.getString("a_user");
                if (user.equals(username)) {
                    return aId; // check username match or not, then return id
                }
            }
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * get all account
     *
     * @return @throws RemoteException RemoteException
     */
    @Override
    public ArrayList getAll() throws RemoteException {
        return this.accounts;
    }

}
