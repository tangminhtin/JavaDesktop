/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.Models;

import RMIServer.Exceptions.PocketException;
import RMIServer.ObjectInfos.Pocket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMIServer.IModels.I_PocketModel;

/**
 *
 * @author tangminhtin
 */
public class PocketModel extends UnicastRemoteObject implements I_PocketModel {

    private Connection connection = null;   // create connection
    private PreparedStatement preparedStatement = null; // create preparedStatement
    private String sql = "";// create sql
    private ResultSet resultSet;// create resultSet

    private ArrayList<Pocket> pockets = null;// create array list pockets
    private ArrayList<Pocket> result = null;// create array list result

    /**
     * Constructor PocketModel
     *
     * @param connection
     * @throws RemoteException
     */
    public PocketModel(Connection connection) throws RemoteException {
        super();
        this.connection = connection; // Initialize connection
        pockets = new ArrayList<>(); // Initialize pockets
        result = new ArrayList<>(); // Initialize result
    }

    /**
     * load pocket
     *
     * @throws RemoteException RemoteException
     */
    @Override
    public void load() throws RemoteException {
        try {
            sql = "SELECT * FROM `pocket` ORDER BY `p_time` ASC"; // sql query
            preparedStatement = connection.prepareStatement(sql); // preparedStatement
            resultSet = preparedStatement.executeQuery(); // excute query
            pockets.clear();   // clear all pockets
            while (resultSet.next()) {
                long pId = resultSet.getLong("p_id"); // get id pocket
                long money = resultSet.getLong("p_money"); // get money
                String description = resultSet.getString("p_description"); // get description
                Date time = resultSet.getDate("p_time"); // get time
                int aId = resultSet.getInt("a_id");// get id account
                pockets.add(new Pocket(pId, money, description, time, aId)); // add pockets to array list
            }
        } catch (SQLException | PocketException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * insert pocket
     *
     * @param money money
     * @param description description
     * @param aId id account
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String insert(long money, String description, int aId) throws RemoteException {
        try {
            sql = "INSERT INTO `pocket`(`p_money`, `p_description`, `a_id`) VALUES (?,?,?)"; // sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setLong(1, money); // set money
            preparedStatement.setString(2, description); // set description
            preparedStatement.setInt(3, aId); // set id account
            preparedStatement.execute();// excute query
            this.load(); // Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * delete pocket
     *
     * @param pId id pocket
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String delete(long pId) throws RemoteException {
        try {
            sql = "DELETE FROM `pocket` WHERE `p_id`=?";// sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setLong(1, pId);// set id pocket
            preparedStatement.execute();// excute query
            this.load(); // Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * update pocket
     *
     * @param pId id pocket
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    @Override
    public String update(long pId, long money, String description) throws RemoteException {
        try {
            sql = "UPDATE `pocket` SET `p_money`=?,`p_description`=? WHERE `p_id`=?"; // sql query
            preparedStatement = connection.prepareStatement(sql);// preparedStatement
            preparedStatement.setLong(1, money);// set money
            preparedStatement.setString(2, description);// set description
            preparedStatement.setLong(3, pId);// set id pocket
            preparedStatement.execute();// excute query
            this.load();// Reload data
            return "Success";
        } catch (SQLException ex) { // show error
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            return "Failed";
        }
    }

    /**
     * search pocket by id
     *
     * @param pId id pocket
     * @return pocket
     * @throws RemoteException RemoteException
     */
    @Override
    public Pocket searchById(long pId) throws RemoteException {
        for (Pocket p : pockets) {
            if (p.getaId() == pId) {
                return p; // return pocket if exist
            }
        }
        return null;
    }

    /**
     * search pocket by aId
     *
     * @param aId id account
     * @return list of pocket
     * @throws RemoteException RemoteException
     */
    @Override
    public ArrayList<Pocket> search(int aId) throws RemoteException {
        result.clear(); // clear old data
        for (Pocket p : pockets) {
            if (p.getaId() == aId) {
                result.add(p); // add p to array list
            }
        }
        return result;
    }

    /**
     * search pocket by aId, date
     *
     * @param aId id account
     * @param date date
     * @return list of pocket
     * @throws RemoteException RemoteException
     */
    @Override
    public ArrayList<Pocket> search(int aId, Date date) throws RemoteException {
        result.clear(); // clear old data
        for (Pocket p : pockets) {
            if ((p.getaId() == aId) && p.getTime().equals(date)) {
                result.add(p); // add p to array list
            }
        }
        return result;
    }

    /**
     * search pocket by aId, fromDate, toDate
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list of pocket
     * @throws RemoteException RemoteException
     */
    @Override
    public ArrayList<Pocket> search(int aId, Date fromDate, Date toDate) throws RemoteException {
        result.clear(); // clear old data
        for (Pocket p : pockets) {
            if ((p.getaId() == aId) && !(p.getTime().before(fromDate) || p.getTime().after(toDate))) {
                result.add(p); // add p to array list
            }
        }
        return result;
    }

    /**
     * total money by aId
     *
     * @param aId id account
     * @return total
     * @throws RemoteException RemoteException
     */
    @Override
    public long total(int aId) throws RemoteException {
        return income(aId) + outcome(aId); // return total money
    }

    /**
     * total money by aId date
     *
     * @param aId id account
     * @param date date
     * @return total
     * @throws RemoteException RemoteException
     */
    @Override
    public long total(int aId, Date date) throws RemoteException {
        return income(aId, date) + outcome(aId, date); // return total money
    }

    /**
     * total money by aId, fromDate, toDate
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return total
     * @throws RemoteException RemoteException
     */
    @Override
    public long total(int aId, Date fromDate, Date toDate) throws RemoteException {
        return income(aId, fromDate, toDate) + outcome(aId, fromDate, toDate); // return total money
    }

    /**
     * income money by aId
     *
     * @param aId id account
     * @return income
     * @throws RemoteException RemoteException
     */
    @Override
    public long income(int aId) throws RemoteException {
        long income = 0; // store income
        for (Pocket p : pockets) {
            // check id and income
            if ((p.getaId() == aId) && p.getMoney() >= 0) {
                income += p.getMoney(); // Calculate income
            }
        }
        return income; // return total income
    }

    /**
     * income money by aId, date
     *
     * @param aId id account
     * @param date date
     * @return income
     * @throws RemoteException RemoteException
     */
    @Override
    public long income(int aId, Date date) throws RemoteException {
        long income = 0; // store income
        for (Pocket p : pockets) {
            // check id and income, date
            if ((p.getaId() == aId) && p.getMoney() >= 0 && p.getTime().equals(date)) {
                income += p.getMoney(); // Calculate income
            }
        }
        return income; // return total income
    }

    /**
     * income money by aId, fromDate, toDate
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list of pocket
     * @throws RemoteException RemoteException
     */
    @Override
    public long income(int aId, Date fromDate, Date toDate) throws RemoteException {
        long income = 0; // store income
        for (Pocket p : pockets) {
            // check id and income, fromDate, toDate
            if ((p.getaId() == aId) && p.getMoney() >= 0 && !(p.getTime().before(fromDate) || p.getTime().after(toDate))) {
                income += p.getMoney(); // Calculate income
            }
        }
        return income; // return total income
    }

    /**
     * outcome money by aId
     *
     * @param aId id account
     * @return income
     * @throws RemoteException RemoteException
     */
    @Override
    public long outcome(int aId) throws RemoteException {
        long outcome = 0; // store outcome
        for (Pocket p : pockets) {
            if ((p.getaId() == aId) && p.getMoney() < 0) { // check id and outcome
                outcome += p.getMoney(); // Calculate outcome
            }
        }
        return outcome; // return total outcome
    }

    /**
     * outcome money by aId, date
     *
     * @param aId id account
     * @param date date
     * @return outcome
     * @throws RemoteException RemoteException
     */
    @Override
    public long outcome(int aId, Date date) throws RemoteException {
        long outcome = 0; // store outcome
        for (Pocket p : pockets) {
            // check id, outcome, date
            if ((p.getaId() == aId) && p.getMoney() < 0 && p.getTime().equals(date)) {
                outcome += p.getMoney(); // Calculate outcome
            }
        }
        return outcome; // return total outcome
    }

    /**
     * outcome money by aId, fromDate, toDate
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return outcome
     * @throws RemoteException RemoteException
     */
    @Override
    public long outcome(int aId, Date fromDate, Date toDate) throws RemoteException {
        long outcome = 0; // store outcome
        for (Pocket p : pockets) {
            // check id, outcome, fromDate, toDate
            if ((p.getaId() == aId) && p.getMoney() < 0 && !(p.getTime().before(fromDate) || p.getTime().after(toDate))) {
                outcome += p.getMoney(); // Calculate outcome
            }
        }
        return outcome; // return total outcome
    }

    /**
     * get size of pocket
     *
     * @return @throws RemoteException RemoteException
     */
    @Override
    public int getSize() throws RemoteException {
        return this.pockets.size();
    }

    /**
     * get all pocket
     *
     * @return list of pocket
     * @throws RemoteException
     */
    @Override
    public ArrayList<Pocket> getAll() throws RemoteException {
        return this.pockets;
    }

}
