/**
 * This abstract class creates the basis of all user types.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar, Parsa Keihan
 */
public abstract class User implements Comparable {
    private String email;
    private String password;
    private int ID;
    private Item usersItem;
    private Basket baskedOfTheUser;
    private Address anAddress;
    /**
     * This constructor creates a user instance
     * @param email, password, ID, userItem, basketOfTheUser, anAddress
     */
    public User( String email, String password, int ID, Item usersItem, Basket basketOfTheUser, Address anAddress){
        this.email = email;
        this.password = password;
        this.ID = ID;;
        this.usersItem = usersItem;
        this.baskedOfTheUser = basketOfTheUser;
        this.anAddress = anAddress;
    }

    /**
     * This method returns the email
     * @return the name of the email
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method sets the email
     * @param email
     * @return null
     */
    public void setEmail( String email){
        this.email = email;
    }

    /**
     * This method sets the password
     * @param password
     * @return null
     */
    public void setPassword( String password) {
        this.password = password;
    }
    /**
     * This method returns the ID
     * @return the name of the ID
     */
    public int getID(){
        return ID;
    }
    /**
     * This method returns the address
     * @return the name of the address
     */
    public Address getAddress(){
        return anAddress;
    }
    /**
     * This method sets the new address
     * @param anAddress
     * @return null
     */
    public void setAddress( Address anAddress) {
        this.anAddress = anAddress;
    }
}
