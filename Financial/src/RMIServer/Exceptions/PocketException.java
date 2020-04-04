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
public class PocketException extends Exception implements Serializable {

    /**
     * Constructor PocketException
     *
     * @param msg message
     */
    public PocketException(String msg) {
        super("PocketException: " + msg);
    }

}
