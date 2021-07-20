import java.util.ArrayList;
/**
 * This class is to store the users input data
 * @version 19 July, 2021
 * @author Ahmet Arda Ceylan, Parsa Keihan
 */
public class UserContainer {

    // Properties
    private static ArrayList<MarketUser> marketUsersList;
    private static ArrayList<CustomerUser> customerUsersList;

    //Constructor
    /**
     * To initialize the lists
     * @param
     */
    public UserContainer(){
        customerUsersList = new ArrayList<>();
        marketUsersList = new ArrayList<>();

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
        try (FileWriter f = new FileWriter("CustomerUsers.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
        { 
            p.println(customerUser.toString()); 
        } catch (IOException i)
        { i.printStackTrace(); }

Read more: https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html#ixzz718F8n3lj
    }

    /**
     * This method adds new marketusers to the arraylist
     * @param marketUser
     * @return null
     */
    public static void addMarketUser(MarketUser marketUser){
        marketUsersList.add(marketUser);
        try (FileWriter f = new FileWriter("MarketUsers.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
        { 
            p.println(marketUser.toString()); 
        } catch (IOException i)
        { i.printStackTrace(); }
    }
        
     /**
     * This method removes marketUsers from the file 
     * @param marketUser
     * @return null
     */    
    public static void removeMarketUser(MarketUser marketUser) throws IOException
    {
        File file = new File("MarketUsers.txt");
        List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(marketUser.toString()))
                        .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
        
    /**
     * This method removes customerUsers from the file 
     * @param customerUser
     * @return null
     */    
    public static void removeMarketUser(CustomerUser customerUser) throws IOException
    {
        File file = new File("CustomerUsers.txt");
        List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(customerUser.toString()))
                        .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }    
        
    
    }    

}
