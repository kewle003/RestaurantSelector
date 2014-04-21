package selectorData;


/**
 * 
 * This class represents a Restaurant object.
 * 
 * @author mark
 *
 */
public class Restaurant {
    
    private String restaurantName;
    private Location location;
    private Address address;
    private PhoneNumber phoneNumber;
    
    public Restaurant(String restaurantName, Location location, Address address, PhoneNumber phoneNumber) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return restaurantName;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    
    public String toString() {
        return "RESTURANT:[restName="+ restaurantName + " , "
                + "location=" + location + " , "
                        + "address=" +address.toString()+ " , "
                                + "phoneNumber=" +phoneNumber+ "]";
    }
    
    public String getMapQuest() {
        return restaurantName + " " + address.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o.getClass() == Restaurant.class))
            return false;
        Restaurant r = (Restaurant) o;
        if (!r.getName().equals(this.getName()))
            return false;
        else if (!r.getAddress().equals(this.getAddress()))
            return false;
        else if (!r.getLocation().equals(this.getLocation()))
            return false;
        return true;
    }

}
