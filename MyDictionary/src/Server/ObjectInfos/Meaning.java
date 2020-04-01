/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.ObjectInfos;

import Server.Exceptions.MeaningException;
import java.io.Serializable;

/**
 *
 * @author tangminhtin
 */
public final class Meaning implements Serializable {

    private int wordID; // Store id of word
    private int typeID; // Store id of type
    private String meaning; // Store meaning

    /**
     * Constructor for Meaning
     *
     * @param wordID id of word
     * @param typeID id of type
     * @param meaning meaning
     * @throws Server.Exceptions.MeaningException
     */
    public Meaning(int wordID, int typeID, String meaning) throws MeaningException {
        this.setWordID(wordID);
        this.setTypeID(typeID);
        this.setMeaning(meaning);
    }

    /**
     * Gets id of word
     *
     * @return id
     */
    public int getWordID() {
        return wordID;
    }

    /**
     * Sets id of word
     *
     * @param wordID id of word
     * @throws Server.Exceptions.MeaningException
     */
    public void setWordID(int wordID) throws MeaningException {
        if (wordID < 0) { // If wordID < 0, then show error
            throw new MeaningException("Word ID must be greater than 0");
        } else {
            this.wordID = wordID;
        }
    }

    /**
     * Gets id of type
     *
     * @return id of type
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Sets id of type
     *
     * @param typeID id of type
     * @throws MeaningException
     */
    public void setTypeID(int typeID) throws MeaningException {
        if (typeID < 0) { // If typeID < 0, then show error
            throw new MeaningException("Type ID must be greater than 0");
        } else {
            this.typeID = typeID;
        }
    }

    /**
     * Gets meaning
     *
     * @return meaning
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Sets meaning
     *
     * @param meaning meaning
     * @throws Server.Exceptions.MeaningException
     */
    public void setMeaning(String meaning) throws MeaningException {
        if (meaning.isEmpty()) { // If meaning is empty, then show error
            throw new MeaningException("Meaning can't be empty");
        } else {   // Otherwise set meaning
            this.meaning = meaning;
        }
    }

    @Override
    public String toString() {
        return "Meaning{" + "wordID=" + wordID + ", typeID=" + typeID + ", meaning=" + meaning + '}';
    }
    
    
}
