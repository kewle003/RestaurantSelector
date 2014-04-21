package selectorData;


/**
 * 
 * This class represents an Address object.
 * 
 * @author mark
 *
 */
public class Address {
    
    private String street;
    private String city;
    private State state;
    private int zipcode;

    public Address(String street, String city, State state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public State getState() {
        return state;
    }
    
    public int getZipcode() {
        return zipcode;
    }
    
    public String toString() {
        return street + " , " +city+ " " +state+ " , " +zipcode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o.getClass() == Address.class))
            return false;
        Address a = (Address) o;
        if (!a.getStreet().equals(this.getStreet()))
            return false;
        else if (!a.getCity().equals(this.getCity()))
            return false;
        else if (!a.getState().equals(this.getState()))
            return false;
        else if (a.getZipcode() != (this.getZipcode()))
            return false;
        return true;
    }

}
