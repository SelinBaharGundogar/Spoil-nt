import java.util.ArrayList;
import java.util.Date;

/**
 * This class creates the basis of all item classees.
 * @version 20 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class Item implements Comparable{
    private String name;
    private String brand;
    private Date dueDate;
    private String category;
    private double price;
    private String measure;
    private double amount;
    private boolean selected;
    private Comment itemComment;

    /**
     * This constructor creates an Item
     * @param name, dueDate, category, brand, price, measure, amount, itemComment
     */
    public Item(String name, Date dueDate, String category, String brand, double price, String measure, double amount, Comment itemComment) {
        this.name = name;
        this.dueDate = dueDate;
        this.category = category;
        this.name = brand;
        this.price = price;
        this.measure = measure;
        this.amount = amount;
        this.itemComment = itemComment;
        selected = false;
        ItemContainer.addItemsList(this);
    }

    /**
     * This method sets the name of the item
     * @return null
     */
    public void setName( String name) {
        this.name = name;
    }

    /**
     * This method returns the name of the item
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the date of the item
     * @return the date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * This method sets the due date of the item
     * @return null
     */
    public void setDueDate( Date dueDate){
        this.dueDate = dueDate;
    }

    /**
     * This method returns the category of the item
     * @return the category
     */
    public String getCategory(){
        return category;
    }

    /**
     * This method sets the category of the item
     * @return null
     */
    public void setCategory( String category){
        this.category = category;
    }

    /**
     * This method returns the brand of the item
     * @return the brand
     */
    public String getBrand(){
        return brand;
    }

    /**
     * This method sets the brand of the item
     * @return null
     */
    public void setBrand( String brand){
        this.brand = brand;
    }

    /**
     * This method returns the price of the item
     * @return the price
     */
    public double getPrice(){
        return price;
    }

    /**
     * This method sets the price of the item
     * @return null
     */
    public void setPrice( double price){
        this.price = price;
    }

    /**
     * This method returns the measure of the item
     * @return the measure
     */
    public String getMeasure(){
        return measure;
    }

    /**
     * This method sets the measure of the item
     * @return null
     */
    public void setMeasure( String measure){
        this.measure = measure;
    }

    /**
     * This method returns the amount of the item
     * @return the amount
     */
    public double getAmount(){
        return amount;
    }

    /**
     * This method sets the amount of the item
     * @return null
     */
    public void setAmount( double amount) {
        this.amount = amount;
    }

    /**
     * This method returns the selected state of the item
     * @return the selected state
     */
    public boolean getSelected(){
        return selected;
    }

    /**
     * This method sets the selection of the item
     * @return null
     */
    public void setSelected() {
        selected = true;
    }

    /**
     * This method returns wheather an item is selected or not
     * @return selected or not
     */
    public boolean isSelected(){
        if ( this.getSelected() ) {
            return true;
        }
        return false;
    }

    /**
     * This method compares the implicit and the explicit parameters
     * @param o
     * @return whether the compared item is bigger or smaller than the latter
     */
    @Override
    public int compareTo(Object o) {
        if ( o instanceof Item ) {
            Item anotherO = (Item) o;
            if (this.getDueDate().after(anotherO.getDueDate())   ) {
                return 1;
            }
            else if (this.getDueDate().before(anotherO.getDueDate())) {
                return -1;
            }
            else if (this.getDueDate().equals((anotherO.getDueDate()))) {
                return 0;
            }
        }
        return 0;
    }

    public String toString(){
        return getName() + "/" + getDueDate() + "/" + getCategory() + "/" + getBrand() + "/" + getPrice() + "/" + getMeasure() + "/" + getAmount() + "/" + itemComment.toString();
    }
}
