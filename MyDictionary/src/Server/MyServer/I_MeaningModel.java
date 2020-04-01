/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.MyServer;

import Server.Exceptions.MeaningException;
import Server.ObjectInfos.Meaning;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public interface I_MeaningModel extends Remote {

    /**
     * Load
     *
     * @throws SQLException
     * @throws MeaningException
     * @throws RemoteException
     */
    public void load() throws SQLException, MeaningException, RemoteException;

    /**
     * Insert
     *
     * @param wordID
     * @param typeID
     * @param newText
     * @return
     * @throws MeaningException
     * @throws RemoteException
     */
    public String insert(int wordID, int typeID, String newText) throws MeaningException, RemoteException;

    /**
     * Delete
     *
     * @param wordID
     * @return
     * @throws MeaningException
     * @throws RemoteException
     */
    public String delete(int wordID) throws MeaningException, RemoteException;

    /**
     * Update
     *
     * @param wordID
     * @param oldTypeID
     * @param newTypeID
     * @param newText
     * @return
     * @throws MeaningException
     * @throws RemoteException
     */
    public String update(int wordID, int oldTypeID, int newTypeID, String newText) throws MeaningException, RemoteException;

    /**
     * Gets size
     *
     * @return @throws RemoteException
     */
    public int getSize() throws RemoteException;

    /**
     * Get meaning
     *
     * @param wordID
     * @return
     * @throws RemoteException
     */
    public ArrayList<Meaning> getMeanings(int wordID) throws RemoteException;

    /**
     * Check exist
     *
     * @param wordID
     * @param typeID
     * @return
     * @throws RemoteException
     */
    public boolean isMeaningExist(int wordID, int typeID) throws RemoteException;

    /**
     * Search
     *
     * @param wordID
     * @param typeID
     * @return
     * @throws RemoteException
     */
    public Meaning searchById(int wordID, int typeID) throws RemoteException;

    /**
     * Search
     *
     * @param meaning
     * @return
     * @throws RemoteException
     */
    public Meaning searchByMeaning(String meaning) throws RemoteException;

}
