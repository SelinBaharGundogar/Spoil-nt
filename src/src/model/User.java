package model;

import java.util.ArrayList;

/**
 * This abstract class creates the basis of all user types.
 * @version 20 July, 2021
 * @author Selin Bahar Gündoğar, Parsa Keihan
 */
public abstract class User implements Comparable, TheUser {
    private String email;
    private String password;
    private Item usersItem;
    private ArrayList<PastItem> pastItems;
    //private  Basket basketOfTheUser;
    private String username;
    /**
     * This constructor creates a user instance
     * @param email, password, ID, userItem, basketOfTheUser, anAddress
     */
    public User( String email, String password,String username){
        this.email = email;
        this.password = password;
        this.username = username;
        pastItems = new ArrayList<>();
        //this.usersItem = usersItem;
        //this.basketOfTheUser = basketOfTheUser;
    }

    @Override
    /**
     * gets current user
     */
    public User currentUser(){
        return this;
    }


    /**
     * This method returns the email
     * @return the name of the email
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method sets the email
     * @param email
     * @return null
     */
    public void setEmail( String email){
        this.email = email;
    }

    /**
     * This method sets the password
     * @param password
     * @return null
     */
    public void setPassword( String password) {
        this.password = password;
    }


    /**
     * This method returns the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    /**
     * gets username
     * @return
     */
    public String getUsername(){
        return username;
    }


    /**
     * sets username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns the ID
     * @return the name of the ID
     */



    @Override
    public int compareTo( Object obj) {
        return 0;
    }


    /**
     * toString method
     * @return
     */
    public String toString(){
        return getEmail() + "/" + getPassword() + "/" + getUsername();
    }
}