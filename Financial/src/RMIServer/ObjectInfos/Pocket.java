/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer.ObjectInfos;

import RMIServer.Exceptions.PocketException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tangminhtin
 */
public final class Pocket implements Serializable, Comparable<Pocket> {

    private long pId;   // store id pocket
    private long money; // money of pocket
    private String description; // description 
    private Date time;// time
    private int aId; // id account

    /**
     * Construct Pocket
     *
     * @param pId id of pocket
     * @param money money of pocket
     * @param description description of pocket
     * @param time time
     * @param aId id of account
     * @throws RMIServer.Exceptions.PocketException
     */
    public Pocket(long pId, long money, String description, Date time, int aId) throws PocketException {
        this.setpId(pId);
        this.setMoney(money);
        this.setDescription(description);
        this.setTime(time);
        this.setaId(aId);
    }

    /**
     * get id of pocket
     *
     * @return id pocket
     */
    public long getpId() {
        return pId;
    }

    /**
     * set id pocket
     *
     * @param pId id pocket
     * @throws RMIServer.Exceptions.PocketException
     */
    public void setpId(long pId) throws PocketException {
        if (pId < 0) {
            throw new PocketException("ERROR: ID must be greater then 0");
        } else {
            this.pId = pId;
        }
    }

    /**
     * get money
     *
     * @return money
     */
    public long getMoney() {
        return money;
    }

    /**
     * set money
     *
     * @param money
     */
    public void setMoney(long money) {
        this.money = money;
    }

    /**
     * get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description
     *
     * @param description description
     * @throws RMIServer.Exceptions.PocketException
     */
    public void setDescription(String description) throws PocketException {
        if (description.trim().isEmpty()) {
            throw new PocketException("ERROR: Description can't be empty!");
        } else {
            this.description = description;

        }
    }

    /**
     * get time
     *
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * set time
     *
     * @param time time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * get id account
     *
     * @return id account
     */
    public int getaId() {
        return aId;
    }

    /**
     * set id account
     *
     * @param aId
     * @throws RMIServer.Exceptions.PocketException
     */
    public void setaId(int aId) throws PocketException {
        if (aId < 0) {
            throw new PocketException("ERROR: Account must be greater than!");
        } else {
            this.aId = aId;
        }
    }

    /**
     * override method toString()
     *
     * @return information of pocket
     */
    @Override
    public String toString() {
        return "Pocket{" + "pId=" + pId + ", money=" + money + ", description=" + description + ", time=" + time + ", aId=" + aId + '}';
    }

    /**
     * override method compareTo
     *
     * @param o object
     * @return int
     */
    @Override
    public int compareTo(Pocket o) {
        return this.time.compareTo(o.getTime());
    }

    /**
     * override method hashCode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.pId ^ (this.pId >>> 32));
        hash = 67 * hash + (int) (this.money ^ (this.money >>> 32));
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.time);
        hash = 67 * hash + this.aId;
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
        final Pocket other = (Pocket) obj;
        if (this.pId != other.pId) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.aId != other.aId) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

}
