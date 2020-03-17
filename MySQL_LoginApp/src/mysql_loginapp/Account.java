/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_loginapp;

/**
 *
 * @author tangminhtin
 */
public class Account {

    private String username;    // Store username
    private String password;    // Store password
    private String fullname;    // Store fullname
    private int gender;         // Store gender (0 male, 1 female)
    private String email;       // Store email
    private String phone;       // Store phone

    /**
     * Constructor for full parameter
     *
     * @param username
     * @param password
     * @param fullname
     * @param gender
     * @param email
     * @param phone
     */
    public Account(String username, String password, String fullname, int gender, String email, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Gets username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets full name
     *
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets full name
     *
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets gender
     *
     * @return
     */
    public int getGender() {
        return gender;
    }

    /**
     * Sets gender
     *
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Gets email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
