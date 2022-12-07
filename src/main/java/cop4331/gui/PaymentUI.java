package cop4331.gui;

import cop4331.client.Cart;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Tommy Las
 */
public class PaymentUI extends JFrame
{
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

        JLabel nameLabel = new JLabel("Full Name: ");

        formPanel.add(nameLabel);

        JTextField fullName = new JTextField();
        fullName.setPreferredSize(new Dimension(150, 20));
        formPanel.add(fullName);

        JLabel cardNumber = new JLabel("Card Number: ");
        formPanel.add(cardNumber);

        JTextField card = new JTextField();
        card.setPreferredSize(new Dimension(150, 20));
        formPanel.add(card);

        JLabel expDateLabel = new JLabel("Expiration Date: ");
        formPanel.add(expDateLabel);

        JTextField expDate = new JTextField();
        expDate.setPreferredSize(new Dimension(150, 20));
        formPanel.add(expDate);

        JLabel secLabel = new JLabel("Security Number: ");
        formPanel.add(secLabel);

        JTextField securityNumber = new JTextField();
        securityNumber.setPreferredSize(new Dimension(150, 20));
        formPanel.add(securityNumber);


        JPanel footerPanel = new JPanel(new GridLayout(3, 1));

        JButton pay = new JButton("Pay");
        pay.addActionListener(e ->
        {
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException ex)
            {
                throw new RuntimeException(ex);
            }
            Cart.getInstance().confirmCart();
            JOptionPane.showMessageDialog(null, "Payment Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        });

        JButton cancel = new JButton("Cancel");
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
