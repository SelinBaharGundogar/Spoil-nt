package sample;

import java.util.ArrayList;

/**
 * This abstract class creates the basis of all user types.
 * @version 20 July, 2021
 * @author Selin Bahar Gündoğar, Parsa Keihan
 */
public abstract class User implements Comparable, TheUser {
    private String email;
    private String password;
    private static int ID;
    private Item usersItem;
    private ArrayList<PastItem> pastItems;
    //private  Basket basketOfTheUser;
    private String username;
    /**
     * This constructor creates a user instance
     * @param email, password, ID, userItem, basketOfTheUser, anAddress
     */
    public User( String email, String password, int ID, String username){
        this.email = email;
        this.password = password;
        this.ID = ID;
        this.username = username;
        pastItems = new ArrayList<>();
        //this.usersItem = usersItem;
        //this.basketOfTheUser = basketOfTheUser;
    }

    @Override
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


    public String getUsername(){
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns the ID
     * @return the name of the ID
     */
    public int getID(){
        return ID;
    }





    @Override
    public int compareTo( Object obj) {
        if ( obj instanceof User ) {
            User newObj = (User) obj;
            if ( this.getID() > newObj.getID() ) {
                return 1;
            }
            else if ( this.getID() < newObj.getID() ) {
                return -1;
            }
            else if (  this.getID() == newObj.getID() ) {
                return 0;
            }
        }
        return 0;
    }


    public String toString(){
        return getEmail() + "/" + getPassword() + "/" + getID() + "/" + getUsername();
    }
}