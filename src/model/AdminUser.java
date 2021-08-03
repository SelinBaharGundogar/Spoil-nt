package model;

/**
 * This  class an Admin User a basket.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class AdminUser extends User
{
    String name;
    String surname;
    static int idCount = 0;
    int id;

    /**
     * This constructor creates a user instance
     * @param email
     * @param password
     * @param username
     */
    public AdminUser(String email, String password,String username,String name,String surname)
    {
        super(email, password,username);
        this.name = name;
        this.surname = surname;
        idCount++;
        id = idCount;
    }

    /**
     * This method returns the user.
     */
    @Override
    public User currentUser()
    {
        return this;
    }

    /**
     * This method is the toString method
     * @return the string representation
     */
    public String toString()
    {
        return super.toString() + "/" + name + "/" + surname;
    }

    /**
     * This method returns the name of the admin user
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * This method sets the name of the admin user
     */
    public void setName(String name)
    {
        this.name = name;

    }

    /**
     * This method returns the ID of the admin user
     * @returns the ID
     */
    public int getID() {
        return id;
    }
}
