package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Product;
import cop4331.gui.InventoryUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mark A.
 */
public class EditProductUI extends JFrame {
    private JLabel name = new JLabel("Name: ");
    private JLabel quantity = new JLabel("Quantity: ");
    private JLabel cost = new JLabel("Cost: ");
    private JLabel price = new JLabel("Price: ");
    public EditProductUI(Product p1){
    
    this.setLayout(new BorderLayout());
    JPanel panel1 = new JPanel(new GridLayout(0, 2));
    
    JButton saveButton = new JButton("Save");
    JTextField textFieldName = new JTextField(p1.getName(),10);
    JTextField textFieldQuantity = new JTextField(Integer.toString(p1.getQuantity()),10);
    JTextField textFieldCost = new JTextField(Double.toString(p1.getCost()),10);
    JTextField textFieldPrice = new JTextField(Double.toString(p1.getPrice()),10);  
 
    JPanel panel2 = new JPanel();
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
    this.setSize(800,1000);
    saveButton.addActionListener(new ActionListener(){
    @Override
     public void actionPerformed(ActionEvent e){
    
       // boolean = confirmation ui
       // if true then save the inventory class otherwise return to the inventory UI and dispose of the frame.
       // save the items into the inventory class and dispose of the frame
  
     }
    });

    
    this.add(panel2, BorderLayout.CENTER);
    this.setVisible(true);
    }
    
}