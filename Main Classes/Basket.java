import java.util.ArrayList;

/**
 * This  class creates a basket.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class Basket implements Comparable{
    private ArrayList<Item> products;
    public Basket() {
        products = new ArrayList<Item>();

    }

    public void removeSelected() {
        for ( int count = 0; count < products.size(); count++ ) {
            if ( products.get(count).isSelected() == true ) {
                products.remove(count);
            }
        }
    }

    public void addItem(Item newItem) {
        products.add(newItem);
    }

    //Todo after the Comparable interface is written
    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
