package cop4331.client;
import java.util.HashMap;

/**
 * @author Tommy Las
 */
public class LoginChecker {
    private HashMap<String, String> loginInformation = new HashMap<>();

    public LoginChecker(){
        loginInformation.put("customer", "1234");
        loginInformation.put("seller", "1234");
    }
    public boolean verifyCredentials(String username, String password){
        return (loginInformation.get(username).equals(password));
    }

}
