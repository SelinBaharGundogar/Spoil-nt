package model;


import java.time.LocalDate;

/**
 * Past products
 * @author Emre Karatas-22001641
 * @version v1.0-20.07.2021
 */
public class PastProducts
{
    public static int rowNumber = 0;
    private LocalDate date;
    private String category,name,market,price;
    private int number;
    private double evaluation;

    /*
    Constructor
     */
    public PastProducts(LocalDate date, String category, String name, String market, String price, int number, double evaluation)
    {
        PastProducts.rowNumber++;
        this.date = date;
        this.category = category;
        this.name = name;
        this.market = market;
        this.price = price;
        this.number = number;
        this.evaluation = evaluation;
    }


}

