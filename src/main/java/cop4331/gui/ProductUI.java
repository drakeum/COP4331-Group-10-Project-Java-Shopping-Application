package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mark A.
 * UI for the product
 */
public class ProductUI extends JFrame
{

    private JLabel id = new JLabel();
    private JLabel name = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel cost = new JLabel();
    private JLabel price = new JLabel();
    private JLabel icon = new JLabel();
    private Product product;
    private JPanel insidePanel = new JPanel(new GridLayout(0, 1, 10, 10));

    /**
     * Constructor for ProductUI
     *
     * @param p1     - a product
     * @param seller - true for seller, false for customer
     */
    public ProductUI(Product p1, boolean seller)
    {

        ImageIcon image = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        
        product = p1;
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setVerticalAlignment(JLabel.CENTER);
        icon.setIcon(image);
        this.setSize(400, 400);
        insidePanel.add(icon);
        getUserPanel();

        // if the user is a seller display the hidden details associated with the product
        if (seller)
        {
            getFullPanel();
        }

    }

    /**
     * adds the full product information that is available both to the user and seller
     * @return returns the instance of the UI panel
     */
    public JPanel viewFullProductDetails()
    {

        quantity.setText(("Quantity: " + Integer.toString(product.getQuantity())));
        quantity.setFont(new Font("MV Boli", Font.PLAIN, 35));
        quantity.setBorder(BorderFactory.createLineBorder(Color.black));
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        insidePanel.add(quantity);

        this.add(insidePanel);
        this.setVisible(true);
        return insidePanel;
    }

    /**
     * displays the hidden details associated with a product
     */
    private void getFullPanel()
    {

        id.setText(("id: " + Integer.toString(product.getId())));
        id.setMinimumSize(new Dimension(30, 30));
        id.setFont(new Font("MV Boli", Font.PLAIN, 35));
        id.setBorder(BorderFactory.createLineBorder(Color.black));
        id.setHorizontalAlignment(SwingConstants.CENTER);
        quantity.setText(("Quantity: " + Integer.toString(product.getQuantity())));
        quantity.setFont(new Font("MV Boli", Font.PLAIN, 35));
        quantity.setBorder(BorderFactory.createLineBorder(Color.black));
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        cost.setFont(new Font("MV Boli", Font.PLAIN, 35));
        if(product.getCost() < 1){
            cost.setText(("Cost: " + Double.toString(product.getCost()) + "¢"));
        } else {
            cost.setText(("Cost: $" + Double.toString(product.getCost())));
        }
        cost.setBorder(BorderFactory.createLineBorder(Color.black));
        cost.setHorizontalAlignment(SwingConstants.CENTER);

        insidePanel.add(quantity);
        insidePanel.add(cost);
        insidePanel.add(id);

    }


    /**
     * adds the basic product information that is available both to the user and seller
     */
    private void getUserPanel()
    {

        name.setText(("Item: " + product.getName()));
        if(product.getPrice() < 1.00){
             price.setText(("Price: " + Double.toString(product.getPrice() ) + "¢"));
        } else {
            price.setText(("Price: $" + Double.toString(product.getPrice())));
        }
        name.setFont(new Font("MV Boli", Font.PLAIN, 35));
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        price.setFont(new Font("MV Boli", Font.PLAIN, 35));
        price.setBorder(BorderFactory.createLineBorder(Color.black));
        price.setHorizontalAlignment(SwingConstants.CENTER);

        insidePanel.add(name);
        insidePanel.add(price);
    }

    /**
     * @return returns the instance of the UI panel
     */
    public JPanel getProductPanel()
    {

        return insidePanel;

    }


}
