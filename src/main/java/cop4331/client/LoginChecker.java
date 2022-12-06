package cop4331.client;
import java.util.HashMap;

/**
 * @author Tommy Las
 */
public class LoginChecker {
    private static HashMap<String, String> customers = new HashMap<>();
    private static HashMap<String, String> sellers = new HashMap<>();

    LoginChecker(){

    }
    public static boolean verifyCustomerCredentials(String username, String password){
        customers.put("customer", "1234");

        return (customers.get(username).equals(password));
    }

    public static boolean verifySellerCredentials(String username, String password){
        sellers.put("seller", "1234");

        return (sellers.get(username).equals(password));
    }
}
