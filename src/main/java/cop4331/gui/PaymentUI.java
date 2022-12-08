package cop4331.gui;

import cop4331.client.Cart;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Payment User Interface
 * Simulates a payment by card
 * @author Tommy Las
 */
public class PaymentUI extends JFrame
{
    /**
     * PaymentUI Constructor
     * Sets up the JFrame with each of its components
     * @param totalPrice amount needed to be paid
     * @author Tommy Las
     */
    public PaymentUI(double totalPrice)
    {

        this.setLayout(new FlowLayout());
        this.setTitle("Payment");
        this.setLocation(400, 100);
        this.setResizable(false);
        this.setSize(400, 450);

        JLabel title = new JLabel();
        title.setText("Enter Payment Information: ");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        this.add(title);

        JPanel formPanel = new JPanel(new GridLayout(4, 1));

        //Name label & textfield
        JLabel nameLabel = new JLabel("Full Name: ");
        formPanel.add(nameLabel);

        JTextField fullName = new JTextField();
        fullName.setPreferredSize(new Dimension(150, 20));
        formPanel.add(fullName);

        //Card number label & textfield
        JLabel cardNumber = new JLabel("Card Number: ");
        formPanel.add(cardNumber);

        JTextField card = new JTextField();
        card.setPreferredSize(new Dimension(150, 20));
        formPanel.add(card);

        //Expiration date label & textfield
        JLabel expDateLabel = new JLabel("Expiration Date: ");
        formPanel.add(expDateLabel);

        JTextField expDate = new JTextField();
        expDate.setPreferredSize(new Dimension(150, 20));
        formPanel.add(expDate);

        //CCV label & textfield
        JLabel secLabel = new JLabel("CCV: ");
        formPanel.add(secLabel);

        JTextField securityNumber = new JTextField();
        securityNumber.setPreferredSize(new Dimension(150, 20));
        formPanel.add(securityNumber);


        JPanel footerPanel = new JPanel(new GridLayout(3, 1));

        JButton pay = new JButton("Pay");
        /**
         * Action listener that simulates the payment with card
         * Pop-up window with success message is displayed
         * @author Tommy Las
         */
        pay.addActionListener(e ->
        {
            //create a delay to simulate a processing of the card
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException ex)
            {
                throw new RuntimeException(ex);
            }
            Cart.getInstance().confirmCart();
            //payment successful, show pop-up message
            if(card.getText().length() != 16){
                JOptionPane.showMessageDialog(null, "Invalid Card Number, Must Be 16 digits", "Please Try Again", JOptionPane.ERROR_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(null, "Payment Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            Cart.getInstance().emptyCart();
            new InventoryUI(false);
            this.dispose();
            }
        });

        JButton cancel = new JButton("Cancel");
        /**
         * ActionListener to cancel payment and return to cart
         * @author Tommy Las
         */
        cancel.addActionListener(e ->
        {
            new InventoryUI(false);
            this.dispose();
        });

        this.add(formPanel);

        JLabel priceLabel = new JLabel("Price is: " + String.format("%.2f", totalPrice));
        priceLabel.setFont(new Font("Calibri", Font.BOLD, 13));
        footerPanel.add(priceLabel);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(pay);
        buttonsPanel.add(cancel);

        footerPanel.add(buttonsPanel);

        this.add(footerPanel);
        this.setVisible(true);
    }
}
