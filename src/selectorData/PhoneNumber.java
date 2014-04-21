package selectorData;
import java.util.StringTokenizer;


/**
 * 
 * This class represents a phoneNumber object.
 * 
 * @author mark
 *
 */
public class PhoneNumber {
    
    public String number;
    
    public PhoneNumber(String number) {
        this.number = number;
    }
    
    public String getPhoneNumber() {
        return number;
    }
    
    public String toString() {
        StringTokenizer st = new StringTokenizer(number);
        return "(" +st.nextToken()+ ") " +st.nextToken();
    }

}
