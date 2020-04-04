/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.Exceptions;

import java.io.Serializable;

/**
 *
 * @author tangminhtin
 */
public class AccountException extends Exception implements Serializable {

    /**
     * Constructor AccountException
     *
     * @param msg message
     */
    public AccountException(String msg) {
        super("AccountException: " + msg);
    }

}
