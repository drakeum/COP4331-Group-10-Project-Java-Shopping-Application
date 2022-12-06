package cop4331.client;
import javax.swing.*;
import java.awt.*;

/**
 * @author Tommy Las
 * Login user interface
 * Customer is able to log in
 */
public class LoginUI extends JFrame {
//    private static JLabel password1, label;
//    private static JTextField username;
//    private static JButton button;
//    private static JPasswordField Password;
    LoginUI(){
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
            System.out.println("Verifying credentials...");

            if(username.getText().equals("seller")){

            }
            else{

            }
            boolean loggedIn = LoginChecker.verifyCustomerCredentials(username.getText(), password.getText());

            System.out.println(loggedIn);
        });

        loginFormPanel.add(loginButton);

        this.add(loginFormPanel);

        this.setVisible(true);

    }
}
