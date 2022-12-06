package cop4331.client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.*;

/**
 *
 * @author Mark A.
 */
public class InventoryUI extends JFrame {
    
    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();
    
    private JButton cartLabel = new JButton();
    private JButton homeLabel = new JButton();
    private JButton addItemLabel = new JButton();
    
    InventoryUI(Inventory inv, Boolean seller) {
    ImageIcon home = new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    homeLabel.setIcon(home);
    if(!seller)
    homeLabel.setBounds(30, 30, 30, 30);
    productList = inv.getProductList();
    this.setLayout(new BorderLayout());
    
    JPanel panel1 = new JPanel();

    panel1.add(homeLabel);
    if(!seller){
    ImageIcon cart = new ImageIcon(new ImageIcon("cart.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    cartLabel.setIcon(cart);
    cartLabel.setBounds(30, 30, 30, 30);
    panel1.add(cartLabel);
    } else {
    ImageIcon addItem = new ImageIcon(new ImageIcon("addItem.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    addItemLabel.setIcon(addItem);
    addItemLabel.setBounds(30, 30, 30, 30);
     panel1.add(addItemLabel);
    }
    JPanel panel2 = new JPanel(new GridLayout(0, 2, 50, 50));
    
    ArrayList<JPanel> pUI = new ArrayList<>();
    productList.forEach((key, value) -> {
        ProductUI p = new ProductUI(value, false, seller);
        JPanel tempPanel = p.getProductPanel();
        if(seller){
            JButton editButton = new JButton("Edit");
            JButton removeButton = new JButton("Remove");
            editButton.setBounds(200, 100, 100, 50);
            removeButton.setBounds(200, 100, 100, 50);
            tempPanel.add(editButton);
            tempPanel.add(removeButton);
        } else {
            JButton addToCartButton = new JButton("Add");
            JButton viewDetailsButton = new JButton("View");
            addToCartButton.setBounds(200, 100, 100, 50);
            viewDetailsButton.setBounds(200, 100, 100, 50);
            tempPanel.add(addToCartButton);
            tempPanel.add(viewDetailsButton);
        }
        tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        pUI.add(tempPanel);
     });
    for(int i = 0; i < pUI.size(); i++){
        panel2.add(pUI.get(i));
    }
    panel1.setPreferredSize(new Dimension(100,65));
    panel1.setBackground(Color.blue);
    this.add(panel1, BorderLayout.NORTH);
    this.add(panel2, BorderLayout.CENTER);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
    
}
