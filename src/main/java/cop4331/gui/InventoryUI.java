package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Mark A.
 */
public class InventoryUI extends JFrame {
    
    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();
    
    private JButton cartButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton addItemButton = new JButton();
    
    public InventoryUI(Boolean userType){
    Inventory inv = Inventory.getInstance();
    ImageIcon home = new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    homeButton.setIcon(home);
    if(!userType)
    homeButton.setBounds(30, 30, 30, 30);
    homeButton.addActionListener(new ActionListener(){
    @Override
     public void actionPerformed(ActionEvent e){
       InventoryUI homePage = new InventoryUI(userType);
       dispose();
     }
    });
    
     this.setSize(800,1000);
    productList = inv.getProductList();
    this.setLayout(new BorderLayout());
    
    JPanel panel1 = new JPanel();

    panel1.add(homeButton);
    if(!userType){
    ImageIcon cart = new ImageIcon(new ImageIcon("cart.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    cartButton.setIcon(cart);
    cartButton.setBounds(30, 30, 30, 30);
    panel1.add(cartButton);
    } else {
    ImageIcon addItem = new ImageIcon(new ImageIcon("addItem.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    addItemButton.setIcon(addItem);
    addItemButton.setBounds(30, 30, 30, 30);
    addItemButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    AddProductUI addProd = new AddProductUI();
                    dispose();
                }
            });
     panel1.add(addItemButton);
    }
    JPanel panel2 = new JPanel(new GridLayout(0, 2, 50, 50));
    
    ArrayList<JPanel> pUI = new ArrayList<>();
    productList.forEach((key, value) -> {
        ProductUI p = new ProductUI(value, userType);
        JPanel tempPanel = p.getProductPanel();
        if(userType){
            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    EditProductUI prod = new EditProductUI(value);
                    dispose();
                }
            });
            JButton removeButton = new JButton("Remove");
            editButton.setBounds(200, 100, 100, 50);
            removeButton.setBounds(200, 100, 100, 50);
            tempPanel.add(editButton);
            tempPanel.add(removeButton);
        } else {
            JButton addToCartButton = new JButton("Add");
            JButton viewDetailsButton = new JButton("View");
            addToCartButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("the key: " + key);
                }
            });
             addToCartButton.setBounds(200, 100, 100, 50);
            viewDetailsButton.setBounds(200, 100, 100, 50);
            tempPanel.add(addToCartButton);
            tempPanel.add(viewDetailsButton);
            viewDetailsButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                     ProductUI p1 = new ProductUI(value, userType);
                     p1.viewFullProductDetails();
                }
            });
        }
        tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        pUI.add(tempPanel);
     });
    for(int i = 0; i < pUI.size(); i++){
        panel2.add(pUI.get(i));
    }
    panel1.setPreferredSize(new Dimension(100,65));
    JScrollPane scrollPane = new JScrollPane(panel2,20,30);  
    scrollPane.setPreferredSize(new Dimension(200, 200));
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
    this.getContentPane().add(scrollPane);  
    panel1.setBackground(Color.blue);
    this.add(scrollPane);
    this.add(panel1, BorderLayout.NORTH);
    this.add(scrollPane, BorderLayout.CENTER);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    
}
