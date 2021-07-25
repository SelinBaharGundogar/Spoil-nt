package sample;

import java.util.Date;

/**
 * This class extends Item.
 * @version 20 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class PastItem {
    public boolean sold;
    public boolean removed;
    public Item anItem;

    /**
     * This constructor creates a pastItem
     * @param anItem
     */
    public PastItem(Item anItem) {

        this.anItem = anItem;
        this.sold = sold;
        this.removed = removed;
        //ItemContainer.addItemsList(this);
    }

    /**
     * This method sets the item being sold to true
     * @return null
     */
    public void setSold(){
        sold = true;
    }




    /**
     * This method sets the item being removed to true
     * @return null
     */
    public void setRemoved(){
        removed = true;
    }

    /**
     * This method returns the sold situation
     * @return situation of sold
     */
    public boolean getSold() {
        return sold;
    }

    /**
     * This method returns the removed situation
     * @return situation of removed
     */
    public boolean getRemoved(){
        return removed;
    }

    public String toString() {
        return super.toString() + "/" + getSold() + "/" + getRemoved();
    }
}
