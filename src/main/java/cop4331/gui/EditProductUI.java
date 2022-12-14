package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Product;
import cop4331.client.StoreInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Mark A.
 * interface for the seller to edit existing products
 */
public class EditProductUI extends JFrame
{
    private JLabel name = new JLabel("Name: ");
    private JLabel quantity = new JLabel("Quantity: ");
    private JLabel cost = new JLabel("Cost: ");
    private JLabel price = new JLabel("Price: ");
    private JPanel pane = new JPanel();
    private Inventory inv = Inventory.getInstance();
    private JPanel panel1 = new JPanel(new GridLayout(0, 2));
    private JButton saveButton = new JButton("Save");
    private JButton returnButton = new JButton("Return");
    private JPanel panel2 = new JPanel();
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");


    public EditProductUI(Product p1)
    {

        this.setLayout(new BorderLayout());
        this.setSize(800, 1000);

        // setting textfield to contain the products data when the frame is opened
        JTextField textFieldName = new JTextField(p1.getName(), 10);
        JTextField textFieldQuantity = new JTextField(Integer.toString(p1.getQuantity()), 10);
        JTextField textFieldCost = new JTextField(Double.toString(p1.getCost()), 10);
        JTextField textFieldPrice = new JTextField(Double.toString(p1.getPrice()), 10);

        panel2.setPreferredSize(new Dimension(600, 600));
        panel2.add(panel1);
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

        //edit item in cart & update cart
        saveButton.addActionListener((e) -> {
           String newName = textFieldName.getText();
            int newQuantity = Integer.parseInt(textFieldQuantity.getText());
            double newCost = Double.parseDouble(textFieldCost.getText());
            double newPrice = Double.parseDouble(textFieldPrice.getText());
            String text = "Are you sure you want to edit this item?";
            String textType = "Confirmation";
            ConfirmationUI conf = new ConfirmationUI(text, textType);
            int confirm = conf.getSelection();
            // edit item, update the cart
             if(confirm == 0){ 
                int prevQuant = p1.getQuantity();
                    inv.editProduct(p1.getId(), newName, newQuantity, newCost, newPrice, 0);

                    if(prevQuant < newQuantity) {
                        StoreInfo.getInstance().buyProductForStore(inv.getProductList().get(p1.getId()), newQuantity - prevQuant);
                    }

                   new InventoryUI(true);
                 } else {
                  new InventoryUI(true);
             }

            });


        // Button action listener that opens up a new inventoryUI and disposes the current JFrame
        returnButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new InventoryUI(true);
                dispose();
            }
        });

        this.add(pane);
        this.add(panel2, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
