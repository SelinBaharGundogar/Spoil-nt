package sample;

import javafx.scene.control.Button;

import java.util.ArrayList;
/**
 * This  class creates a basket.
 * @version 19 July, 2021
 * @author Selin Bahar Gündoğar and Parsa Keihan
 */
public class CustomerUser extends User {

    //Properties
    ArrayList<Item> currentItems;
    String userName;
    String address;
    String name;
    String Surname;
    String number;
    private  Basket basketOfTheUser;
    private Button addCommentButton;


//Constructor
    /**
     * This constructor creates a costumer user instance
     * @param email
     * @param password
     * @param ID
     * @param anAddress
     */
    public CustomerUser(String email, String password, int ID, String anAddress, String userName) {
        super(email, password, ID, userName);
        currentItems = new ArrayList<Item>();
        basketOfTheUser = new Basket();
        addCommentButton = new Button("Add Comment");
        //UserContainer.addCustomerUser(this);
    }
    
    public Button getAddCommentButton(){
        return addCommentButton;
    }
    public void setaddCommentButton( Button addCommentButton){
        this.addCommentButton = addCommentButton;
    }
    
    public Basket getBasketOfTheUser() {
        return basketOfTheUser;
    }

    public void setBasketOfTheUser(Basket basketOfTheUser) {
        this.basketOfTheUser = basketOfTheUser;
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

    public void setCurrentItems(ArrayList<Item> currentItems) {
        this.currentItems = currentItems;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setAddCommentButton(Button addCommentButton) {
        this.addCommentButton = addCommentButton;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + getUserName() + "/" + currentItems.toString();
    }

}
