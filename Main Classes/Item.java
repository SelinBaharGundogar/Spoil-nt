import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class creates the basis of all item classees.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class Item {
    private String name;
    private String brand;
    private Date dueDate;
    private String category;
    private double price;
    private String measure;
    private double amount;
    private boolean selected;
    private Comment itemComment;
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
    }

    public void setName( String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate( Date dueDate){
        this.dueDate = dueDate;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory( String category){
        this.category = category;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand( String brand){
        this.brand = brand;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice( double price){
        this.price = price;
    }
    public String getMeasure(){
        return measure;
    }
    public void setMeasure( String measure){
        this.measure = measure;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount( double amount) {
        this.amount = amount;
    }
    public boolean getSelected(){
        return selected;
    }
    public void setSelected() {
        selected = true;
    }
    public boolean isSelected(){
        if ( this.getSelected() ) {
            return true;
        }
        return false;
    }
}
