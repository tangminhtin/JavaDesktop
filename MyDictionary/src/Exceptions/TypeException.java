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
public class TypeException extends Exception {

    /**
     * Constructor for TypeException
     *
     * @param message error
     */
    public TypeException(String message) {
        super("Type Exception: " + message);
    }

}
