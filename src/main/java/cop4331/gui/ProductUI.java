package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mark A.
 */
public class ProductUI extends JFrame {
    
    private JLabel id = new JLabel();
    private JLabel name = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel cost = new JLabel();
    private JLabel price = new JLabel();
    private JLabel icon = new JLabel();
    private Product p;
    JPanel insidePanel = new JPanel(new GridLayout(0, 1, 10, 10));
    
    public ProductUI(Product p1, boolean seller){
        ImageIcon image = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        p = p1;
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setVerticalAlignment(JLabel.CENTER);
        icon.setIcon(image);
        this.setSize(400,400);
        insidePanel.add(icon);
        getUserPanel();
        if(seller){ 
         getFullPanel();
        } 
    }
    
    public void viewFullProductDetails() {  
        getFullPanel();
        this.add(insidePanel);
        this.setVisible(true);
    }
    
    
    private void getFullPanel() {  
    id.setText(("id: " + Integer.toString(p.getId())));
    id.setMinimumSize(new Dimension(30, 30));
    id.setFont(new Font("MV Boli", Font.PLAIN,35));
    id.setBorder(BorderFactory.createLineBorder(Color.black));
    id.setHorizontalAlignment(SwingConstants.CENTER);
    quantity.setText(("Quantity: " + Integer.toString(p.getQuantity())));
    quantity.setFont(new Font("MV Boli", Font.PLAIN,35));
    quantity.setBorder(BorderFactory.createLineBorder(Color.black));
    quantity.setHorizontalAlignment(SwingConstants.CENTER);
    cost.setFont(new Font("MV Boli", Font.PLAIN,35));
    cost.setText(("Cost: " + Double.toString(p.getCost()) + "$"));
    cost.setBorder(BorderFactory.createLineBorder(Color.black));
    cost.setHorizontalAlignment(SwingConstants.CENTER);
    insidePanel.add(quantity);
    insidePanel.add(cost);
    insidePanel.add(id);
    }
    
    private void getUserPanel() {    
        

        name.setText(("Item: " + p.getName()));
        price.setText(("Price: " + Double.toString(p.getPrice())+ "$"));     
        name.setFont(new Font("MV Boli", Font.PLAIN,35));
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        price.setFont(new Font("MV Boli", Font.PLAIN,35));
        price.setBorder(BorderFactory.createLineBorder(Color.black));
        price.setHorizontalAlignment(SwingConstants.CENTER);
        insidePanel.add(name);
        insidePanel.add(price);
    }
    public JPanel getProductPanel() {    
    return insidePanel;
    }
    
    
}
