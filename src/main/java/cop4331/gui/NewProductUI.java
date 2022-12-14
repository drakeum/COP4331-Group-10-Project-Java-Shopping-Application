package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.StoreInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Mark A.
 * interface for the seller to add items
 */
public class NewProductUI extends JFrame
{
    private JLabel id = new JLabel("id: ");
    private JLabel name = new JLabel("Name: ");
    private JLabel quantity = new JLabel("Quantity: ");
    private JLabel cost = new JLabel("Cost: ");
    private JLabel price = new JLabel("Price: ");
    private JButton saveButton = new JButton("Add Product");
    private JButton returnButton = new JButton("Return");
    private Inventory inv = Inventory.getInstance();
    private JPanel panel1 = new JPanel(new GridLayout(0, 2));
    private JTextField textFieldId = new JTextField(10);
    private JTextField textFieldName = new JTextField(10);
    private JTextField textFieldQuantity = new JTextField(10);
    private JTextField textFieldCost = new JTextField(10);
    private JTextField textFieldPrice = new JTextField(10);

    public NewProductUI()
    {
        // setting the layout for the JFrame
        this.setLayout(new BorderLayout());
        this.setSize(800, 1000);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(600, 600));
        panel2.add(panel1);

        // adding all the JLabels/Buttons to the panel
        panel1.add(id);
        panel1.add(textFieldId);
        panel1.add(name);
        panel1.add(textFieldName);
        panel1.add(quantity);
        panel1.add(textFieldQuantity);
        panel1.add(cost);
        panel1.add(textFieldCost);
        panel1.add(price);
        panel1.add(textFieldPrice);
        panel1.add(saveButton);
        panel1.add(returnButton);

        // Button action listener that adds a new product to the inventory and refreshes the page.
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                inv.addProduct(Integer.parseInt(textFieldId.getText()), textFieldName.getText(), Integer.parseInt(textFieldQuantity.getText()), Double.parseDouble(textFieldCost.getText()), Double.parseDouble(textFieldPrice.getText()));
                dispose();
                new InventoryUI(true);
            }
        });

        // Button action listener that opens a new inventoryUI and disposes the current JFrame
        returnButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new InventoryUI(true);
                dispose();
            }
        });

        this.add(panel2, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
