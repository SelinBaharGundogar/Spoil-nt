package sample;

import java.util.ArrayList;
/**
 * This class is to store the items input data
 * @version 19 July, 2021
 * @author Ahmet Arda Ceylan
 */
public class ItemContainer {

    // Properties
    private static ArrayList<Item> itemsList;
    private static ArrayList<PastItem> pastItemsList;

    //Constructor
    /**
     * To initialize the lists
     */
    public ItemContainer(){
        itemsList = new ArrayList<>();
        pastItemsList = new ArrayList<>();
    }

    /**
     * This method returns the arrayList of the items
     * @return the itemsList
     */
    public static ArrayList<Item> getItemsList() { return itemsList; }

    /**
     * This method returns the arrayList of the past items
     * @return the pastItemsList
     */
    public static ArrayList<PastItem> getPastItemsList() { return pastItemsList; }

    /**
     * This method adds new items to the arraylist
     * @param item
     * @return null
     */
    public static void addItemsList(Item item) {
        itemsList.add(item);
    }

    /**
     * This method adds new past items to the arraylist
     * @param pastItem
     * @return null
     */
    public static void addItemsList(PastItem pastItem) {
        pastItemsList.add(pastItem);
    }
}