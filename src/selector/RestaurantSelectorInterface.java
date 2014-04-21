package selector;

import java.util.List;

import selectorData.User;

public interface RestaurantSelectorInterface {

    /**
     * 
     * This method will return the user's ID
     * who is currently logged in.
     * 
     * @return
     */
    public int getUserId();
    
    /**
     * 
     * This method will log the user
     * into the program, it requires
     * the unique userId.
     * 
     * @param userId
     * @return
     */
    public void logIn(int userId) throws Exception;
    
    /**
     * 
     * This method will return the details
     * of the user logged into our system.
     * 
     * @return
     */
    public String getUserLoggedIn();
    
    /**
     * 
     * This method will make the user's
     * selection randomly based on the user's
     * favorite restaurants.
     * 
     * @return
     */
    public String makeSelection();
    
    /**
     * 
     * This method will update the user
     * database.
     * 
     * @param newUsers
     * @throws Exception
     */
    public void updateUserDatabase(List<User> newUsers) throws Exception;
    
    /**
     * 
     * This method checks to see if an Administrator
     * is logged in.
     * 
     * @return
     */
    public boolean isAdmin();
    
    /**
     * 
     * This method checks to see if a Moderator
     * is logged in.
     * 
     * @return
     */
    public boolean isModerator();
    
    
}
