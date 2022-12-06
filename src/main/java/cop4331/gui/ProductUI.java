package cop4331.gui;

import cop4331.client.Product;

import javax.swing.*;
import java.awt.*;

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
    JPanel insidePanel = new JPanel(new GridLayout(0, 1, 10, 10));
    
    ProductUI(Product p1, boolean viewFullProductDetails, boolean seller){
        ImageIcon image = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setVerticalAlignment(JLabel.CENTER);
        icon.setIcon(image);
        this.setSize(400,400);
        insidePanel.add(icon);
        if(viewFullProductDetails || seller){ 
         quantity.setText(("Quantity: " + Integer.toString(p1.getQuantity())));
         quantity.setFont(new Font("MV Boli", Font.PLAIN,35));
         quantity.setBorder(BorderFactory.createLineBorder(Color.black));
         quantity.setHorizontalAlignment(SwingConstants.CENTER);
         cost.setFont(new Font("MV Boli", Font.PLAIN,35));
         cost.setText(("Cost: " + Double.toString(p1.getCost()) + "$"));
         cost.setBorder(BorderFactory.createLineBorder(Color.black));
         cost.setHorizontalAlignment(SwingConstants.CENTER);
         insidePanel.add(quantity);
         insidePanel.add(cost);
        }
        id.setText(("id: " + Integer.toString(p1.getId())));
        id.setMinimumSize(new Dimension(30, 30));
        id.setFont(new Font("MV Boli", Font.PLAIN,35));
        id.setBorder(BorderFactory.createLineBorder(Color.black));
        id.setHorizontalAlignment(SwingConstants.CENTER);
        name.setText(("Item: " + p1.getName()));
        price.setText(("Price: " + Double.toString(p1.getPrice())+ "$"));     
        name.setFont(new Font("MV Boli", Font.PLAIN,35));
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        price.setFont(new Font("MV Boli", Font.PLAIN,35));
        price.setBorder(BorderFactory.createLineBorder(Color.black));
        price.setHorizontalAlignment(SwingConstants.CENTER);
        
        insidePanel.add(id);
        insidePanel.add(name);
        insidePanel.add(price);

        
    }
    
    public JPanel getProductPanel() {    
    return insidePanel;
    }
    
    
}
