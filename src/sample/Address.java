package sample;

/**
 * This model class takes in the components of an address.
 * @version 18 July, 2021
 * @author Selin Bahar Gündoğar
*/
public class Address
{
    // Properties
    private String street;
    private String city;
    private String district;
    private String country;
    private int postalCode;
    
    // Constructors
    /**
     * This constructor creates an address instance
     * @param street, city, distict, country, postalCode
     */
    public Address( String street, String city, String district, String country, int postalCode ){
        this.street = street;
        this.city = city;
        this.district = district;
        this.country = country;
        this.postalCode = postalCode;
    }



    // Methods
    /**
     * This method checks if the param input is equal to the implicit parameter
     * @param anAddress
     * @return param is equal or not to the implicit parameter
     */
    public boolean validate( Address anAddress) {
        if (this.getStreet().equalsIgnoreCase(anAddress.getStreet()) && (this.getCity().equalsIgnoreCase(anAddress.getCity())) && (this.getDistrict().equalsIgnoreCase(anAddress.getDistrict())) && (this.getCountry().equalsIgnoreCase(anAddress.getCountry())) && (this.getpostalCode() == anAddress.getpostalCode())) {
            return true;
        }
        return false;
    }
    /**
     * This method returns the street
     * @return the name of the street
     */
    public String getStreet(){
        return street;
    }

    /**
     * This method returns the city name
     * @return the name of the street
     */
    public String getCity(){
        return city;
    }

    /**
     * This method returns the district
     * @return the name of the district
     */
    public String getDistrict(){
        return district;
    }
    /**
     * This method returns the country
     * @return the name of the country
     */
    public String getCountry(){
        return country;
    }
    /**
     * This method returns the postalCode
     * @return the value of the postalcode
     */
    public int getpostalCode(){
        return postalCode;
    }
}