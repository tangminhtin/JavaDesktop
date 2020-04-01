/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.MyServer;

import Server.Exceptions.WordException;
import Server.ObjectInfos.Word;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public interface I_WordModel extends Remote {

    /**
     *
     * @throws SQLException
     * @throws WordException
     * @throws RemoteException
     */
    public void load() throws SQLException, WordException, RemoteException;

    /**
     *
     * @param newText
     * @return
     * @throws WordException
     * @throws RemoteException
     */
    public String insert(String newText) throws WordException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws WordException
     * @throws RemoteException
     */
    public String delete(int id) throws WordException, RemoteException;

    /**
     *
     * @param id
     * @param newText
     * @return
     * @throws WordException
     * @throws RemoteException
     */
    public String update(int id, String newText) throws WordException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean isWordExit(int id) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public Word searchById(int id) throws RemoteException;

    /**
     *
     * @param text
     * @return
     * @throws RemoteException
     */
    public Word searchByFullWord(String text) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public int getSize() throws RemoteException;

    /**
     *
     * @param text
     * @return
     * @throws RemoteException
     */
    public ArrayList<Word> search(String text) throws RemoteException;

    /**
     *
     * @param wordID
     * @return
     * @throws RemoteException
     */
    public String showWord(int wordID) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<String> showDictionary() throws RemoteException;

    /**
     *
     * @param wordID
     * @return
     * @throws RemoteException
     */
    public String showMeaningOnly(int wordID) throws RemoteException;

    /**
     *
     * @param wordID
     * @param text
     * @return
     * @throws RemoteException
     */
    public boolean isWordCorrect(int wordID, String text) throws RemoteException;

    /**
     *
     * @param m
     * @param n
     * @return
     * @throws RemoteException
     */
    public int random(int m, int n) throws RemoteException;

    /**
     *
     * @param num
     * @param isShuffle
     * @return
     * @throws RemoteException
     */
    public ArrayList<Word> generateTest(int num, boolean isShuffle) throws RemoteException;
    
}
