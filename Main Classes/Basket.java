import java.util.ArrayList;

/**
 * This  class creates a basket.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class Basket {
    private ArrayList<Item> products;
    /**
     * This constructor creates a basket instance
     */
    public Basket() {
        products = new ArrayList<Item>();

    }

    /**
     * This method removes the selected item
     * @return null
     */
    public void removeSelected() {
        for ( int count = 0; count < products.size(); count++ ) {
            if ( products.get(count).isSelected() ) {
                products.remove(count);
            }
        }
    }

    /**
     * This method adds an item to to the basket
     * @return null
     */
    public void addItem(Item newItem) {
        products.add(newItem);
    }
}
