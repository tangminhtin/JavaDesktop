/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectInfos;

import Exceptions.TypeException;

/**
 *
 * @author tangminhtin
 */
public final class Type {

    private int id;         // Store id of type
    private String text;    // Store text of type

    /**
     * Constructor for Type
     *
     * @param id id of type
     * @param text text of type
     * @throws TypeException
     */
    public Type(int id, String text) throws TypeException {
        this.setId(id);
        this.setText(text);
    }

    /**
     * Gets id of type
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of type
     *
     * @param id id of type
     * @throws TypeException
     */
    public void setId(int id) throws TypeException {
        if (id < 0) { // If id < 0, then show error
            throw new TypeException("Type ID must be greater than 0");
        } else { // Otherwise set id
            this.id = id;
        }
    }

    /**
     * Gets text of type
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text of type
     *
     * @param text text of type
     * @throws TypeException
     */
    public void setText(String text) throws TypeException {
        if (text.isEmpty()) {   // If text is empty, then show error
            throw new TypeException("Type name can't be empty");
        } else { // Otherwise set text
            this.text = text;
        }
    }

}
