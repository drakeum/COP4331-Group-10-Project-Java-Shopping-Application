package cop4331.gui;

import cop4331.client.LoginChecker;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tommy Las
 * Login user interface
 * Customer or Seller is able to log in
 */

public class LoginUI extends JFrame
{
    /**
     * LoginUI Constructor
     * Sets up the JFrame with each of its components
     * @author Tommy Las
     */
    public LoginUI()
    {
        //this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setLocation(500, 100);
        this.setResizable(false);

        this.setSize(500, 500);

        //Label and texfield for username
        JPanel loginFormPanel = new JPanel();
        loginFormPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(100, 8, 70, 20);
        loginFormPanel.add(usernameLabel);

        //Label and textfield for password
        JTextField username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        loginFormPanel.add(username);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 55, 70, 20);
        loginFormPanel.add(passwordLabel);

        JTextField password = new JPasswordField();
        password.setBounds(100, 75, 193, 28);
        loginFormPanel.add(password);


        //Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 90, 25);

        /**
         * Button action listener that verify whether the credentials are ok and login the customer or seller
         * @author Tommy Las
         */
        loginButton.addActionListener((e) ->
        {
            LoginChecker loginChecker = new LoginChecker();

            //verify credentials
            boolean loggedIn = loginChecker.verifyCredentials(username.getText(), password.getText());

            if (loggedIn == false)
            {
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "Cannot Login", JOptionPane.ERROR_MESSAGE);
            } else
            {
                if (username.getText().equals("seller"))
                {
                    //if username is seller, then display the inventory for seller
                    new InventoryUI(true);
                } else
                {
                    //display the inventory for customer
                    new InventoryUI(false);
                }
                this.dispose();
            }


        });

        loginFormPanel.add(loginButton);

        this.add(loginFormPanel);

        this.setVisible(true);

    }
}
