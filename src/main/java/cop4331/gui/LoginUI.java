package cop4331.gui;
import cop4331.client.LoginChecker;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tommy Las
 * Login user interface
 * Customer is able to log in
 */
public class LoginUI extends JFrame {
    public LoginUI(){
        //this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setLocation(500, 100);
        this.setResizable(false);
        this.setSize(500,500);

        JPanel loginFormPanel = new JPanel();
        loginFormPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(100, 8, 70, 20);
        loginFormPanel.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        loginFormPanel.add(username);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 55, 70, 20);
        loginFormPanel.add(passwordLabel);

        JTextField password = new JPasswordField();
        password.setBounds(100, 75, 193, 28);
        loginFormPanel.add(password);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 90, 25);
        loginButton.addActionListener((e) -> {
            LoginChecker loginChecker = new LoginChecker();

            boolean loggedIn = loginChecker.verifyCredentials(username.getText(), password.getText());

            if(username.getText().equals("seller")){
                new InventoryUI(true);
            }
            else{
                new InventoryUI(false);
            }
            this.dispose();
        });

        loginFormPanel.add(loginButton);

        this.add(loginFormPanel);

        this.setVisible(true);

    }
}
