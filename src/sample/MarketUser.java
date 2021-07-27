package sample;//import static org.graalvm.compiler.options.OptionType.User;

import javafx.scene.image.Image;

import java.awt.*;

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

    //Constructor
    /**
     * This constructor creates a market user instance
     * @param email
     * @param password
     * @param ID
     * @param anAddress
     */
    public MarketUser(String email, String password, int ID, String anAddress, String marketName)
    {
        super(email, password, ID, anAddress);
        this.marketName = marketName;
        this.email = email;
        this.password = password;
        address = anAddress;
        marketImage = new Image("Images/market-logo.jpg");
        //UserContainer.addMarketUser(this);
    }

    @Override
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

    public void setMarketImage(Image marketImage)
    {
        this.marketImage = marketImage;
    }

    public Image getMarketImage()
    {
        return marketImage;
    }



    /**
     * assigns a name to the specified market
     * @param marketName
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public void setPassword(String password)
    {
        this.password = password;

    }

    public String getPassword()
    {
        return password;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public int compareTo(Object o) {
        if ( o instanceof MarketUser ) {
            MarketUser anotherObject = (MarketUser) o;
            if ( this.getID() > anotherObject.getID()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + getMarketName();
    }

    public String getEmail()
    {
        return email;
    }
}

