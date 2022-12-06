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
 * interface for the seller to edit existing products
 */
public class EditProductUI extends JFrame {
    private JLabel name = new JLabel("Name: ");
    private JLabel quantity = new JLabel("Quantity: ");
    private JLabel cost = new JLabel("Cost: ");
    private JLabel price = new JLabel("Price: ");
    private JLabel amountToBeSold = new JLabel("Amount to be sold: ");
    private JPanel pane = new JPanel();
    private Inventory inv = Inventory.getInstance();
    private JPanel panel1 = new JPanel(new GridLayout(0, 2));
    private JButton saveButton = new JButton("Save");
    private JButton returnButton = new JButton("Return");
    private JPanel panel2 = new JPanel();
    private JButton confirmButton = new JButton("Confirm");
    private JButton cancelButton = new JButton("Cancel");
    
    
    public EditProductUI(Product p1){
    this.setLayout(new BorderLayout());
    JTextField textFieldName = new JTextField(p1.getName(),10);
    JTextField textFieldQuantity = new JTextField(Integer.toString(p1.getQuantity()),10);
    JTextField textFieldCost = new JTextField(Double.toString(p1.getCost()),10);
    JTextField textFieldPrice = new JTextField(Double.toString(p1.getPrice()),10);
    JTextField textFieldAmountToBeSold = new JTextField(Integer.toString(p1.getAmountToBeSold()),10);
    
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
    panel1.add(amountToBeSold);
    panel1.add(textFieldAmountToBeSold);
    panel1.add(saveButton);
    panel1.add(returnButton);
    
    this.setSize(800,1000);
    saveButton.addActionListener(new ActionListener(){
    @Override
     public void actionPerformed(ActionEvent e){
       dispose();
       ConfirmationUI confirmationUI = new ConfirmationUI();
       pane = confirmationUI.getPanel();
       
       pane.add(confirmButton);
       confirmButton.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
              inv.editProduct(p1.getId(),textFieldName.getText(),Integer.parseInt(textFieldQuantity.getText()),Double.parseDouble(textFieldCost.getText()),Double.parseDouble(textFieldPrice.getText()),Integer.parseInt(textFieldAmountToBeSold.getText()));
              confirmationUI.dispose();
              InventoryUI inv = new InventoryUI(true);
           }
         });
       
       pane.add(cancelButton);
       cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            confirmationUI.dispose();
            InventoryUI inv = new InventoryUI(true);
           }    
        });
       
     }
    });
    returnButton.addActionListener(new ActionListener(){
    @Override
     public void actionPerformed(ActionEvent e){
      InventoryUI inv = new InventoryUI(true);
      dispose();
     }
    });

    this.add(pane);
    this.add(panel2, BorderLayout.CENTER);
    this.setVisible(true);
    }
    
}
