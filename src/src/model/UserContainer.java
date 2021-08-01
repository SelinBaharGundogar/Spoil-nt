package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
/**
 * This class is to store the users input data
 * @version 19 July, 2021
 * @author Ahmet Arda Ceylan, Parsa Keihan,Emre Karatas
 */
public class UserContainer {

    // Properties
    public static CustomerUser currentUser;
    public static MarketUser currentMarket;
    public static MarketUser activeMarketUser;
    public static CustomerUser activeCustomerUser;
    public static AdminUser currentAdmin;
    public static AdminUser activeAdminUser;

    public static ArrayList<MarketUser> marketUsersList;
    public static ArrayList<CustomerUser> customerUsersList;
    public static ArrayList<AdminUser> adminUsersList;

    //UserContainer.customerUsersList.get(i);
    //Constructor
    /**
     * To initialize the lists
     * @param
     */
    public UserContainer()
    {
        //currentMarket = new MarketUser("", "", "", "", new Image("Images/market-logo.jpg"));
        customerUsersList = new ArrayList<>();
        marketUsersList = new ArrayList<>();
        adminUsersList = new ArrayList<>();
        //currentUser = new CustomerUser("","","0","", "", "");
        //currentAdmin = new AdminUser("","","","","");

        //activeCustomerUser = new CustomerUser("","","","", "", "");
        //activeMarketUser = new MarketUser("", "", 0, "", "", new Image("Images/market-logo.jpg"));
        //activeAdminUser = new AdminUser("","",0,"","","");
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
     * This method returns the arrayList of the admin users
     * @return the marketUsersList
     */
    public static ArrayList<AdminUser> getAdminUsersList() { return adminUsersList; }

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
    public static void addMarketUser(MarketUser marketUser)
    {
        if ( UserContainer.marketUsersList != null)
            marketUsersList.add(marketUser);
    }

    /**
     * This class adds admins
     * @param adminUser
     */
    public static void addAdminUser(AdminUser adminUser)
    {
        adminUsersList.add(adminUser);
    }


}
