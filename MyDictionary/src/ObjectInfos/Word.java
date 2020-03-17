/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectInfos;

import Exceptions.WordException;

/**
 *
 * @author tangminhtin
 */
public final class Word {

    private int id;         // Store id of word
    private String text;    // Store text of word

    /**
     * Constructor for Word
     *
     * @param id id of word
     * @param text text of word
     * @throws WordException
     */
    public Word(int id, String text) throws WordException {
        this.setId(id);
        this.setText(text);
    }

    /**
     * Gets id of word
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of word
     *
     * @param id id of word
     * @throws WordException
     */
    public void setId(int id) throws WordException {
        if (id < 0) { // If id < 0, then show error
            throw new WordException("Word ID must be greater than 0");
        } else { // Otherwise set id
            this.id = id;
        }
    }

    /**
     * Gets text of word
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text of word
     *
     * @param text text of word
     * @throws WordException
     */
    public void setText(String text) throws WordException {
        if (text.isEmpty()) {   // If text is empty, then show error
            throw new WordException("Word name can't be empty");
        } else { // Otherwise set text
            this.text = text;
        }
    }

}
