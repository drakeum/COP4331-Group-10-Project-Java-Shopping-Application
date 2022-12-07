package cop4331.client;

import java.util.HashMap;

/**
 * Verifies credentials to log the user in
 * @author Tommy Las
 */
public class LoginChecker
{
    private HashMap<String, String> loginInformation = new HashMap<>();

    /**
     * LoginChecker constructor that adds username and passwords and stores it in a HashMap
     * @author Tommy Las
     */
    public LoginChecker()
    {
        loginInformation.put("customer", "1234");
        loginInformation.put("seller", "1234");
    }

    /**
     * Method that verifies credentials from the user with the ones stored
     * @param username
     * @param password
     * @return whether the credentials given by the user match with the credentials stored
     * @author Tommy Las
     */
    public boolean verifyCredentials(String username, String password)
    {
        if (loginInformation.get(username) == null)
        {
            return false;
        }
        return (loginInformation.get(username).equals(password));
    }

}
