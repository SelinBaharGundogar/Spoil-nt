package model;//import static org.graalvm.compiler.options.OptionType.User;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates market user extending the user abstract class
 * @version 18 July, 2021
 * @author Parsa Keihan
 */
public class MarketUser extends User{

    //Properties
    String marketName;
    String email;
    String password;
    String address;
    Image marketImage;
    ArrayList<Item> anItem;
    static int idCount = 0;
    int id;

    //Constructor
    /**
     * This constructor creates a market user instance
     * @param email
     * @param password
     * @param anAddress
     * @param marketImage
     */
    public MarketUser(String email, String password, String anAddress, String marketName, Image marketImage)
    {
        super(email, password, anAddress);
        this.marketName = marketName;
        this.email = email;
        this.password = password;
        address = anAddress;
        this.marketImage = marketImage;
        anItem = new ArrayList<Item>();
        UserContainer.addMarketUser(this);
        idCount++;
        id = MarketUser.idCount;
    }

    @Override
    /**
     * Current user
     */
    public User currentUser(){
        return this;
    }

    /**
     * gets the specified market's name
     * @return the name of the market
     */
    public String getMarketName() {
        return marketName;
    }

    /**
     * Setting market image
     * @param marketImage
     */
    public void setMarketImage(Image marketImage)
    {
        this.marketImage = marketImage;
    }

    /**
     * Getting market image
     * @return
     */
    public Image getMarketImage()
    {
        return marketImage;
    }

    /**
     * Adding item to market
     * @param theItem
     */
    public void addItem( Item theItem){
        anItem.add(theItem);
    }

    /**
     * Getting all items
     * @return
     */
    public List<Item> getAllItems(){
        return anItem;
    }

    /**
     * Getting items
     * @return
     */
    public List<Item> getItems(){
        List<Item> temp = new ArrayList<>();
        for ( Item a : getAllItems() ){
            if ( a.getStatus() != -1) {
                temp.add(a);
            }
            }
        return temp;
    }


    /**
     * assigns a name to the specified market
     * @param marketName
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    /**
     * Setting password
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;

    }

    /**
     * Getting password
     * @return
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Getting address
     * @return
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Setting address
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    /**
     * ToString method
     */
    public String toString() {
        return super.toString() + "/" + getMarketName();
    }

    /**
     * Getting email
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Getting image
     * @return
     */
    public Image getImage()
    {
        return marketImage;
    }

    /**
     * Getting ID
     * @return
     */
    public int getID() {
        return id;
    }
}
