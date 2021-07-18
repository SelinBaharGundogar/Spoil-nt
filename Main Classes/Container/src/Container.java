import java.util.ArrayList;
/**
 * This class is to store the input data
 * @version 18 July, 2021
 * @author Parsa Keihan
 */
public class Container {

    // Properties
    ArrayList<Comment> commentArrayList;
    ArrayList<Item> itemArrayList;
    ArrayList<Market> marketArrayList;
    ArrayList<Costumer> costumerArrayList;

    //Constructorss
    /**
     * To hold Comments
     * @param comment
     */
    public Container( Comment comment ){
        commentArrayList = new ArrayList<>();
    }

    /**
     * To hold Items
     * @param item
     */
    public Container( Item item ){
        itemArrayList = new ArrayList<>();
    }

    /**
     * To hold Markets
     * @param market
     */
    public Container( Market market ){
        marketArrayList = new ArrayList<>();
    }

    /**
     * To hold Costumers
     * @param costumer
     */
    public Container( Costumer costumer ){
        costumerArrayList = new ArrayList<>();
    }

}
