package selectorData;
import java.util.List;


/**
 * 
 * This class represents a user object.
 * 
 * @author mark
 *
 */
public class User {
    
    private int userId;
    private String userName;
    private List<Restaurant> favRestaurants;
    private Address address;
    private Role role;
    
    
    public User(int userId, String userName, Address address, List<Restaurant> favRestaurants, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.favRestaurants = favRestaurants;
        this.role = role;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<Restaurant> getFavoriteRestaurants() {
        return favRestaurants;
    }
    
    public void setFavoriteRestaurants(List<Restaurant> favRestaurants) {
        this.favRestaurants = favRestaurants;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    
    /**
     * 
     * This method will add on to the User's favorite
     * Restaurants.
     * 
     * @param newList
     */
    public void updateRestaurants(List<Restaurant> newList) {
        if (favRestaurants != null && newList != null) {
            for ( Restaurant newRest : newList ) {
                if (!favRestaurants.contains(newRest))
                    favRestaurants.add(newRest);
            }
        }
    }
    
    /**
     * 
     * If the user wishes to remove a restaurant
     * this method will handle that.
     * 
     * @param rest
     */
    public void removeRestaurant(Restaurant rest) {
        if (favRestaurants != null) {
            favRestaurants.remove(rest);
        }
    }
    
    public String toString() {
        return "USER:[userId=" +userId+" , userName=" +userName+ " , "
                + "userAddress=" +address+ " , "
                + "userRole=" +role+ " , "
                        + "favRests=" +favRestaurants.toString()+ "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o.getClass() == User.class))
            return false;
        User u = (User) o;
        if (u.getUserId() != this.getUserId())
            return false;
        else if (!u.getUserName().equals(this.getUserName()))
            return false;
        else if (!u.getFavoriteRestaurants().equals(this.getFavoriteRestaurants()))
            return false;
        else if (!u.getRole().equals(this.getRole()))
            return false;
        return true;
    }

}
