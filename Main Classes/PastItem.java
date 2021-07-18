import java.util.Date;

/**
 * This class extends Item.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class PastItem extends Item{
    public boolean sold;
    public boolean removed;
    public PastItem(String name, Date dueDate, String category, String brand, double price, String measure, double amount, Comment itemComment, boolean removed, boolean sold) {
        super(name, dueDate, category, brand, price, measure, amount, itemComment);
        this.sold = sold;
        this.removed = removed;
    }
    public void setSold(){
        sold = true;
    }
    public void setRemoved(){
        removed = true;
    }
    public boolean getSold() {
        return sold;
    }
    public boolean getRemoved(){
        return removed;
    }
}
