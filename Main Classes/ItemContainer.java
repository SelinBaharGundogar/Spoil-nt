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
        try (FileWriter f = new FileWriter("ItemsList.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
        { 
            p.println(item.toString()); 
        } catch (IOException i)
        { i.printStackTrace(); }

    }

    /**
     * This method adds new past items to the arraylist
     * @param pastItem
     * @return null
     */
    public static void addItemsList(PastItem pastItem) {
        pastItemsList.add(pastItem);
        try (FileWriter f = new FileWriter("PastItemsList.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
        { 
            p.println(pastItem.toString()); 
        } catch (IOException i)
        { i.printStackTrace(); }

    }
    
    
    /**
     * This method removes items from the file 
     * @param items
     * @return null
     */    
    public static void removeItem(Item item) throws IOException
    {
        File file = new File("ItemsList.txt");
        List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(item.toString()))
                        .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
    
     /**
     * This method removes PastItems from the file 
     * @param PastItems
     * @return null
     */    
    public static void removePastItem(PastItem pastItem) throws IOException
    {
        File file = new File("PastItemsList.txt");
        List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(pastItem.toString()))
                        .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }


}
