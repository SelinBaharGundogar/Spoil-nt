package model;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * This  class creates a CustomerUser.
 * @version 19 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class CustomerUser extends User {

    //Properties
    ArrayList<Item> currentItems;
    String userName;
    String address;
    String name;
    String surname;
    String email;
    //Basket basketOfTheUser;
    static int idCount = 0;
    public int id;


//Constructor
    /**
     * This constructor creates a costumer user instance
     * @param email
     * @param password
     * @param address
     */
    public CustomerUser(String email, String password,String userName, String address, String name, String surname ) {
        super(email, password, userName);
        this.email = email;
        this.userName = userName;
        this.address = address;
        this.surname = surname;
        this.name = name;
        currentItems = new ArrayList<Item>();
        idCount++;
        id = CustomerUser.idCount;
    }


    /**
     * sets the username for an individual
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public User currentUser(){
        return this;
    }

    /**
     * gets the username of a specified costumer
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the email
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the current Items
     * @param currentItems
     */
    public void setCurrentItems(ArrayList<Item> currentItems) {
        this.currentItems = currentItems;
    }

    /**
     * Sets the address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the surname
     * @param surname
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }



    /**
     * This method returns current items
     * @return currentItems
     */
    public List<Item> getCurrentItems() {
        return currentItems;
    }

    /**
     * This method adds an item
     * @param anItem
     */
    public void addItem( Item anItem) {
        currentItems.add(anItem);
    }

    /**
     * Returns the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the surname of the user
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + getAddress() + "/" + getName()+ "/"+  getSurname()+ "/" + currentItems.toString();
    }

    /**
     * Returns the ID
     * @return id
     */
    public int getID() {
        return id;
    }


}
