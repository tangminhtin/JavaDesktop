/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.IModels;

import RMIServer.ObjectInfos.Account;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public interface I_AccountModel extends Remote {

    /**
     * load account
     *
     * @throws RemoteException RemoteException
     */
    public void load() throws RemoteException;

    /**
     *
     * insert account
     *
     * @param username username
     * @param password password
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String insert(String username, String password) throws RemoteException;

    /**
     * delete account
     *
     * @param aId id account
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String delete(int aId) throws RemoteException;

    /**
     * update account
     *
     * @param aId id account
     * @param username username
     * @param password password
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String update(int aId, String username, String password) throws RemoteException;

    /**
     * search account by id
     *
     * @param aId id account
     * @return account
     * @throws RemoteException RemoteException
     */
    public Account searchById(int aId) throws RemoteException;

    /**
     * search account by username
     *
     * @param username username
     * @return account
     * @throws RemoteException RemoteException
     */
    public Account searchByUsername(String username) throws RemoteException;

    /**
     * search account
     *
     * @param query query
     * @return list of account
     * @throws RemoteException RemoteException
     */
    public ArrayList<Account> search(String query) throws RemoteException;

    /**
     * get size
     *
     * @return @throws RemoteException RemoteException
     */
    public int getSize() throws RemoteException;

    /**
     * check exist or not
     *
     * @param username username
     * @return true or false
     * @throws RemoteException RemoteException
     */
    public boolean isExist(String username) throws RemoteException;

    /**
     * login
     *
     * @param username username
     * @param password password
     * @return id of account
     * @throws RemoteException RemoteException
     */
    public int login(String username, String password) throws RemoteException;

    /**
     * get all account
     *
     * @return @throws RemoteException RemoteException
     */
    public ArrayList getAll() throws RemoteException;
}
