/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.ObjectInfos;

import RMIServer.Exceptions.AccountException;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tangminhtin
 */
public final class Account implements Serializable, Comparable<Account> {

    private int aId;        // account id
    private String username;    // username of account
    private String password; // password of account

    /**
     * constructor Account
     *
     * @param aId id of account
     * @param username username of account
     * @param password password of account
     * @throws RMIServer.Exceptions.AccountException
     */
    public Account(int aId, String username, String password) throws AccountException {
        this.setaId(aId);
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     * get id
     *
     * @return id
     */
    public int getaId() {
        return aId;
    }

    /**
     * set id
     *
     * @param aId id
     * @throws RMIServer.Exceptions.AccountException
     */
    public void setaId(int aId) throws AccountException {
        if (aId < 0) {
            throw new AccountException("ERROR: ID must be greater then 0");
        } else {
            this.aId = aId;
        }
    }

    /**
     * get username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username username
     * @throws RMIServer.Exceptions.AccountException
     */
    public void setUsername(String username) throws AccountException {
        if (username.trim().isEmpty()) {
            throw new AccountException("ERROR: Username can't be empty!");
        } else {
            this.username = username;

        }
    }

    /**
     * get password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     *
     * @param password password
     * @throws RMIServer.Exceptions.AccountException
     */
    public void setPassword(String password) throws AccountException {
        if (password.trim().isEmpty()) {
            throw new AccountException("ERROR: Password can't be empty!");
        } else {
            this.password = password;

        }

    }

    /**
     * override method toString()
     *
     * @return info of account
     */
    @Override
    public String toString() {
        return "Account{" + "aId=" + aId + ", username=" + username + ", password=" + password + '}';
    }

    /**
     * override method compareTo
     *
     * @param o object account
     * @return int
     */
    @Override
    public int compareTo(Account o) {
        return this.username.compareTo(o.getUsername());
    }

    /**
     * override method hashCode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.aId;
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
        return hash;
    }

    /**
     * override method equals
     *
     * @param obj object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return true;
    }

}
