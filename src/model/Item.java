package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class creates the basis of all item classes.
 * @version 20 July, 2021
 * @author Selin Bahar Gündoğar
 */
public class Item implements  TheItem, Comparable{
    private String name;
    private String brand;
    private String market;
    private LocalDate dueDate;
    private String category;
    private double price;
    private String measure;
    private double amount;
    private String removed;
    private double score;
    private boolean selected;
    int itemID;
    static int idCount = 0;
    private int status;//1 -> current, 0 -> reserved, -1 -> past
    private boolean sold;//true -> sold, false -> removed



    /**
     * This constructor creates an Item
     * @param name, dueDate, category, brand, price, measure, amount, itemComment
     */
    public Item(String name, String market, LocalDate dueDate, String category, String brand, double price, String measure, double amount) {
        this.name = name;
        this.market = market;
        this.dueDate = dueDate;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.measure = measure;
        this.amount = amount;

        idCount++;
        this.itemID = idCount;
        selected = true;
        removed = "";
        sold = false;
        status = 1;
        score = 0;
    }

    /**
     * gets the score
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * sets the score
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * set to selected
     * @param selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    /**
     * get an item's ID
     * @return the ID
     */
    public  int getItemID() {
        return itemID;
    }

    /**
     * sets an item's ID
     * @param itemID
     */
    public  void setItemID(int itemID) {
        itemID = idCount;
    }

    /**
     * gets the next ID
     * @return the ID count
     */
    public static int getNextID() {
        return idCount;
    }

    /**
     * sets the next ID
     * @param idCount
     */
    public static void setNextID(int idCount) {
        idCount = idCount;
    }

    /**
     * sets the status of an item
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * checks the status
     * @return true if it is sold
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * set the status of an item if it is sold or not
     * @param sold
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * gets the status of an item
     * @return
     */
    public int getStatus(){
        return status;
    }

    /**
     * This method sets the name of the item
     * @return null
     */
    public void setName( String name) {
        this.name = name;
    }

    /**
     * gets market
     * @return the market
     */
    public String getMarket() {
        return market;
    }



    /**
     * gets the ID
     * @return the ID
     */
    public int getID(){
        return itemID;
    }

    /**
     * sets the market
     * @param market
     */
    public void setMarket(String market) {
        this.market = market;
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
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * This method sets the due date of the item
     * @return null
     */
    public void setDueDate( LocalDate dueDate){
        this.dueDate = dueDate;
    }

    /**
     * This method returns the category of the item
     * @return the category
     */
    public String getCategory(){
        return this.category;
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
    public String getRemovalState(){
        if (setRemoved() == true ) {
            return "removed";
        }
        else if ( setSoldOUt() == true ) {
            return "Sold out";
        }
        return "";
    }

    public boolean setRemoved()
    {
        removed = "removed";
        return selected= true;
    }
    private boolean setSoldOUt() {
        return sold = true;
    }

    /**
     * This method sets the selection of the item
     * @return null
     */
    public boolean setSelected()
    {
        removed = "removed";
        return selected = true;
    }

    public boolean getSelected(){
        return selected;
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
     * @param
     * @return whether the compared item is bigger or smaller than the latter
     */
   // @Override
    public int compareTo(Object o) {
        if ( o instanceof Item ) {
            Item anotherO = (Item) o;
            if (this.getPrice() > anotherO.getPrice()  ) {
                return 1;
            }
            else if (this.getPrice() < anotherO.getPrice() ) {
                return -1;
            }
            else if (this.getPrice() == anotherO.getPrice() ) {
                return 0;
            }
        }
        return 0;
    }

    /**
     * gets the current item
     * @return the current item
     */
    @Override
    public Item currentItem() {
        return this;
    }

    /**
     * A string representation
     * @return string representation
     */
    public String toString(){
        return getName() + "/" + getDueDate() + "/" + getCategory() + "/" + getBrand() + "/" + getPrice() + "/" + getMeasure() + "/" + getAmount() + "/" + "removebutton" +  "/" + "dueDate" + getSelected() + "/" + getRemovalState() + "/" +"removed";
    }
}
