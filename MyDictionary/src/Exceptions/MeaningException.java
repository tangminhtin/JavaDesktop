/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author tangminhtin
 */
public class MeaningException extends Exception {

    /**
     * Constructor for MeaningException
     *
     * @param message error
     */
    public MeaningException(String message) {
        super("Meaning Exception: " + message);
    }

}
