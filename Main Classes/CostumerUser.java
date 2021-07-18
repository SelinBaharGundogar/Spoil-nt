import java.util.ArrayList;

public class CostumerUser extends User implements Comparable{

    //Properties
    ArrayList<Item> currentItems;
    String userName;

    //Constructor
    /**
     * This constructor creates a costumer user instance
     * @param email
     * @param password
     * @param ID
     * @param usersItem
     * @param basketOfTheUser
     * @param anAddress
     */
    public CostumerUser(String email, String password, int ID, Item usersItem, Basket basketOfTheUser, Address anAddress, String userName) {
        super(email, password, ID, usersItem, basketOfTheUser, anAddress);
        this.userName = userName;
        currentItems = new ArrayList<Item>();
    }

    /**
     * sets the username for an individual
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * gets the username of a specified costumer
     * @return
     */
    public String getUserName() {
        return userName;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
