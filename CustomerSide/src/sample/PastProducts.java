package sample;


import java.time.LocalDate;

public class PastProducts
{
    public static int rowNumber = 0;
    private LocalDate date;
    private String category,name,market,price;
    private int number;
    private double evaluation;

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

