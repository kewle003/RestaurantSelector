package selectorDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import selectorData.User;
import selectorExceptions.InvalidDataException;
import selectorExceptions.NoDataFoundException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;



public class DatabaseManager {
    
    private String filename;
    
    /**
     * @param filename - the location of the JSON file we wish to read
     */
    public DatabaseManager(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * This will grab the Users in the database.
     * 
     * @return List<StudentRecord> objects
     */
    public List<User> readOutUserRecords() throws Exception {
        List<User> userRecords = null;
        try {
            if (filename != null) {
                userRecords = new Gson().fromJson(new FileReader(new File(
                        filename)), new TypeToken<List<User>>() {
                }.getType());

                //Check if there was data in the JSON
                if (userRecords == null) {
                    throw new NoDataFoundException("No data found in JSON file " +filename);
                }
            } else {
                throw new InvalidDataException("filename: " +filename+ " is invalid");
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return userRecords;
    }
    
    /**
     * 
     * This method will update the database with
     * new user information.
     * 
     * @param newUsers
     * @return
     */
    public boolean updateUserRecords(List<User> newUsers) {
        String fileToWrite = new GsonBuilder().setPrettyPrinting().create()
                .toJson(newUsers);
        try {
            FileWriter file = new FileWriter(filename);
            file.write(fileToWrite);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
