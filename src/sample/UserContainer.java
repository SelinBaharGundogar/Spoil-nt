package sample;

import java.util.ArrayList;
/**
 * This class is to store the users input data
 * @version 19 July, 2021
 * @author Ahmet Arda Ceylan, Parsa Keihan
 */
public class UserContainer {

    // Properties
    static CustomerUser currentUser;
    static int currentMarket;

    static ArrayList<MarketUser> marketUsersList;
    static ArrayList<CustomerUser> customerUsersList;

    //UserContainer.customerUsersList.get(i);
    //Constructor
    /**
     * To initialize the lists
     * @param
     */
    public UserContainer(){
        currentMarket = 0;
        customerUsersList = new ArrayList<>();
        marketUsersList = new ArrayList<>();
        currentUser = new CustomerUser("","",12,"","");
    }


    /**
     * This method returns the arrayList of the market users
     * @return the marketUsersList
     */
    public static ArrayList<MarketUser> getMarketUsersList() { return marketUsersList; }

    /**
     * This method returns the arrayList of the customer users
     * @return the customerUsersList
     */
    public static ArrayList<CustomerUser> getCustomerUsersList() { return customerUsersList; }

    /**
     * This method adds new customerusers to the arraylist
     * @param customerUser
     * @return null
     */
    public static void addCustomerUser(CustomerUser customerUser){
        customerUsersList.add(customerUser);
    }

    /**
     * This method adds new marketusers to the arraylist
     * @param marketUser
     * @return null
     */
    public static void addMarketUser(MarketUser marketUser){
        marketUsersList.add(marketUser);
    }
}
