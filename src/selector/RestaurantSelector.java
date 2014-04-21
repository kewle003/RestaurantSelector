package selector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import selectorData.Restaurant;
import selectorData.Role;
import selectorData.User;
import selectorDatabase.DatabaseManager;
import selectorExceptions.InvalidDataException;
import selectorExceptions.InvalidLoginException;
import selectorExceptions.NoDataFoundException;


public class RestaurantSelector implements RestaurantSelectorInterface {
    
    private User user;
    private HashMap<Integer, User> users = new HashMap<Integer, User>();
    private static String CWD = System.getProperty("user.dir");
    private DatabaseManager userDatabase;
    
    /**
     * 
     * Constructor for our RestaurantSelector program.
     * This will connect to the database and grab the Users
     * in the database. After doing so it will populate the
     * HashMap.
     * 
     * @param jsonText
     */
    public RestaurantSelector(String jsonText) {
        userDatabase = new DatabaseManager(CWD+"/data/" +jsonText);
        ArrayList<User> usersDatabase = null;
        try {
            usersDatabase = (ArrayList<User>) userDatabase.readOutUserRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Populate the HashMap
        for (User u : usersDatabase) {
            users.put(u.getUserId(), u);
        }
        
    }

    @Override
    public int getUserId() {
        return user.getUserId();
    }

    @Override
    public void logIn(int userId) throws Exception{
        if (users.containsKey(userId)) {
            user = users.get(userId);
            
        } else
            throw new InvalidLoginException("Invalid user: " +userId);
        
    }

    @Override
    public String getUserLoggedIn() {
        return user.toString();
    }

    @Override
    public String makeSelection() {
        if (user.getFavoriteRestaurants() != null) {
            List<Restaurant> rests = user.getFavoriteRestaurants();
            return rests.get((int) Math.floor(Math.random()*(rests.size()))).getName();
        } else {
            return "You do not have any resturaunts stored";
        }
    }
    
    @Override
    public void updateUserDatabase(List<User> newUsers) throws Exception {
        if (newUsers != null) {
            userDatabase.updateUserRecords(newUsers);
        } else {
            throw new InvalidDataException("You can not store a null list of users");
        }
        
    }
    
    @Override
    public boolean isAdmin() {
        if (user.getRole().equals(Role.ADMIN))
            return true;
        else
            return false;
    }
    
    @Override
    public boolean isModerator() {
        if (user.getRole().equals(Role.MODERATOR))
            return true;
        else
            return false;
    }
    
    @Override
    public void updateFavoriteRestaurant(List<Restaurant> newRestaurants) throws Exception {
        List<User> userList = (List<User>) users.values();
        if (userList.remove(user)) {
            user.updateRestaurants(newRestaurants);
            userList.add(user);
            updateUserDatabase(userList);
        } else {
            throw new NoDataFoundException("User: " +user.getUserId()+ " not found!");
        }
    }


    public static void main(String[] args) {
        RestaurantSelector r = new RestaurantSelector("data.txt");
        String selection = new String("");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Login ID:");
        try {
            r.logIn(keyboard.nextInt());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        while(true) {
            System.out.println("-------- WELCOME --------");
            System.out.println("Would you like me to choose a restaurant? (Y/N)");
            selection = keyboard.nextLine();
            if (selection.equalsIgnoreCase("y"))
                System.out.println(r.makeSelection());
            System.out.println("Continue? (Y/N)");
            selection = keyboard.nextLine();
            if (selection.equalsIgnoreCase("N"))
                break;
            System.out.println();   
        }
        
        System.out.println("Have a nice Day!");
    }

    

}
