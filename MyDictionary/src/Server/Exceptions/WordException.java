/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Exceptions;

/**
 *
 * @author tangminhtin
 */
public class WordException extends Exception {

    /**
     * Constructor for WordException
     *
     * @param message error
     */
    public WordException(String message) {
        super("Word Exception: " + message);
    }

}
