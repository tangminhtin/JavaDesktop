/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.IModels;

import RMIServer.ObjectInfos.Pocket;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tangminhtin
 */
public interface I_PocketModel extends Remote {

    /**
     * load pocket
     *
     * @throws RemoteException RemoteException
     */
    public void load() throws RemoteException;

    /**
     * insert pocket
     *
     * @param money money
     * @param description description
     * @param time time
     * @param aId id account
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String insert(long money, String description, Date time, int aId) throws RemoteException;

    /**
     * delete pocket
     *
     * @param pId id pocket
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String delete(long pId) throws RemoteException;

    /**
     * update pocket
     *
     * @param pId id pocket
     * @param money money
     * @param description description
     * @return success or fail
     * @throws RemoteException RemoteException
     */
    public String update(long pId, long money, String description) throws RemoteException;

    /**
     * search pocket by id
     *
     * @param pId id pocket
     * @return pocket
     * @throws RemoteException RemoteException
     */
    public Pocket searchById(long pId) throws RemoteException;

    /**
     * search list pocket by id
     *
     * @param aId id account
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public ArrayList<Pocket> search(int aId) throws RemoteException;

    /**
     * search list pocket
     *
     * @param aId id account
     * @param date date
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public ArrayList<Pocket> search(int aId, Date date) throws RemoteException;

    /**
     * search list pocket
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public ArrayList<Pocket> search(int aId, Date fromDate, Date toDate) throws RemoteException;

    /**
     * total list pocket
     *
     * @param aId id account
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public long total(int aId) throws RemoteException;

    /**
     * total list pocket
     *
     * @param aId id account
     * @param date date
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public long total(int aId, Date date) throws RemoteException;

    /**
     * total list pocket
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public long total(int aId, Date fromDate, Date toDate) throws RemoteException;

    /**
     * income list pocket
     *
     * @param aId id account
     * @return list pocket
     * @throws RemoteException RemoteException
     */
    public long income(int aId) throws RemoteException;

    /**
     * income list pocket
     *
     * @param aId id account
     * @param date date
     * @return list pocket
     * @throws RemoteException
     */
    public long income(int aId, Date date) throws RemoteException;

    /**
     * income list pocket
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list pocket
     * @throws RemoteException
     */
    public long income(int aId, Date fromDate, Date toDate) throws RemoteException;

    /**
     * outcome
     *
     * @param aId id account
     * @return list pocket
     * @throws RemoteException
     */
    public long outcome(int aId) throws RemoteException;

    /**
     * outcome
     *
     * @param aId id account
     * @param date date
     * @return list pocket
     * @throws RemoteException
     */
    public long outcome(int aId, Date date) throws RemoteException;

    /**
     * outcome
     *
     * @param aId id account
     * @param fromDate fromDate
     * @param toDate toDate
     * @return list pocket
     * @throws RemoteException
     */
    public long outcome(int aId, Date fromDate, Date toDate) throws RemoteException;

    /**
     * get size
     *
     * @return size
     * @throws RemoteException RemoteException
     */
    public int getSize() throws RemoteException;

    /**
     * get all pocket
     *
     * @return list of pocket
     * @throws RemoteException
     */
    public ArrayList<Pocket> getAll() throws RemoteException;

}
