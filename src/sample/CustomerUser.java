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
        return addCommentButton
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



    @Override
    public String toString() {
        return super.toString() + "/" + getUserName() + "/" + currentItems.toString();
    }

}
