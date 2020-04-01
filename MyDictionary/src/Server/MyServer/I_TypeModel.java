/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.MyServer;

import Server.Exceptions.TypeException;
import Server.ObjectInfos.Type;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public interface I_TypeModel extends Remote {

    /**
     * load
     * @throws SQLException
     * @throws TypeException
     * @throws RemoteException
     */
    public void load() throws SQLException, TypeException, RemoteException;

    /**
     * insert
     * @param newText
     * @return
     * @throws TypeException
     * @throws RemoteException
     */
    public String insert(String newText) throws TypeException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws TypeException
     * @throws RemoteException
     */
    public String delete(int id) throws TypeException, RemoteException;

    /**
     *
     * @param id
     * @param newText
     * @return
     * @throws TypeException
     * @throws RemoteException
     */
    public String update(int id, String newText) throws TypeException, RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public int getSize() throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public Type searchById(int id) throws RemoteException;

    /**
     *
     * @param typeID
     * @return
     * @throws RemoteException
     */
    public boolean isTypeExist(int typeID) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<String> getTypeList() throws RemoteException;

    /**
     *
     * @param text
     * @return
     * @throws RemoteException
     */
    public Type searchByName(String text) throws RemoteException;
}
