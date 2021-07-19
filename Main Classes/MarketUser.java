/**
 * This class creates market user extending the user abstract class
 * @version 19 July, 2021
 * @author Parsa Keihan and Selin Bahar Gundogar
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
}
