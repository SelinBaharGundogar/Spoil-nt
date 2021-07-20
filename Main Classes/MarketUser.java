/**
 * This class creates market user extending the user abstract class
 * @version 18 July, 2021
 * @author Parsa Keihan
 */
public class MarketUser extends User{

    //Properties
    String marketName;

    //Constructor
    /**
     * This constructor creates a market user instance
     * @param email
     * @param password
     * @param ID
     * @param usersItem
     * @param basketOfTheUser
     * @param anAddress
     */
    public MarketUser(String email, String password, int ID, Item usersItem, Basket basketOfTheUser, Address anAddress, String marketName) {
        super(email, password, ID, usersItem, basketOfTheUser, anAddress);
        this.marketName = marketName;
        UserContainer.addMarketUser(this);
    }

    /**
     * gets the specified market's name
     * @return the name of the market
     */
    public String getMarketName() {
        return marketName;
    }

    /**
     * assigns a name to the specified market
     * @param marketName
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Override
    public int compareTo(Object o) {
        if ( o instanceof MarketUser ) {
            MarketUser anotherObject = (MarketUser) o;
            if ( this.getID() > anotherObject.getID()) {
                return
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + getMarketName();
    }
}
