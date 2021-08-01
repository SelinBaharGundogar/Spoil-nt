package model;

public class AdminUser extends User
{
    String name;
    String surname;
    static int idCount = 0;
    int id;

    /**
     * This constructor creates a user instance
     *
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

    @Override
    public User currentUser()
    {
        return this;
    }
    public String toString()
    {
        return super.toString() + "/" + name + "/" + surname;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;

    }

    public int getID() {
        return id;
    }
}
