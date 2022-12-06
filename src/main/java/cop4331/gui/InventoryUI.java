package cop4331.gui;

import cop4331.client.Cart;
import cop4331.client.Inventory;
import cop4331.client.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author Mark A.
 * a store inventory interface for both the seller and user, depending on who is logged in. 
 * If the seller is logged in then they can edit and remove items.
 * Users can view items in detail and also add them to their cart.
 */
public class InventoryUI extends JFrame implements ActionListener {

    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();

    private JButton cartButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton addItemButton = new JButton();
    private JButton storeInfoButton = new JButton();
    private Inventory inv = Inventory.getInstance();
    private JPanel pane = new JPanel();
    private ImageIcon home = new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private JButton editButton = new JButton("Edit");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(new GridLayout(0, 2, 50, 50));
    private JComboBox comboBox;
    private Boolean userAccess;
    private String[] order = {"Name asc","Name dsc","Price asc","Price dsc"};

    public InventoryUI(Boolean userType)
    {
        userAccess = userType;
        homeButton.setIcon(home);
        if (!userType)
            homeButton.setBounds(30, 30, 30, 30);
        homeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                InventoryUI homePage = new InventoryUI(userType);
                dispose();
            }
        });
        cartButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CartUI cart = new CartUI();
                dispose();
            }
        });

        this.setSize(800, 1000);
        productList = inv.getProductList();
        this.setLayout(new BorderLayout());
 
        comboBox = new JComboBox(order);
        comboBox.addActionListener(this);
        
        panel1.add(comboBox);
        panel1.add(homeButton);
        if (!userType)
        {
            ImageIcon cart = new ImageIcon(new ImageIcon("cart.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            cartButton.setIcon(cart);
            cartButton.setBounds(30, 30, 30, 30);
            panel1.add(cartButton);
        } else
        {
            ImageIcon storeInfo = new ImageIcon(new ImageIcon("storeInfo.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            storeInfoButton.setIcon(storeInfo);
            storeInfoButton.setBounds(30, 30, 30, 30);
            ImageIcon addItem = new ImageIcon(new ImageIcon("addItem.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            addItemButton.setIcon(addItem);
            addItemButton.setBounds(30, 30, 30, 30);
            addItemButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    NewProductUI addProd = new NewProductUI();
                    dispose();
                }
            });
            panel1.add(addItemButton);
            panel1.add(storeInfoButton);
        }


        ArrayList<JPanel> pUI = new ArrayList<>();
        productList.forEach((key, value) ->
        {
            ProductUI p = new ProductUI(value, userType);
            JPanel tempPanel = p.getProductPanel();
            if (userType)
            {

                JButton editButton = new JButton("Edit");
                editButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        EditProductUI prod = new EditProductUI(value);
                        dispose();
                    }

                });

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                        dispose();
                        ConfirmationUI confirmationUI = new ConfirmationUI();
                        pane = confirmationUI.getPanel();
                        JButton confirmButton = new JButton("Confirm");
                        JButton cancelButton = new JButton("Cancel");
                        pane.add(confirmButton);

                        confirmButton.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                inv.removeProduct(value.getId());
                                confirmationUI.dispose();
                                InventoryUI inv = new InventoryUI(true);
                            }
                        });
                        pane.add(cancelButton);
                        cancelButton.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                confirmationUI.dispose();
                                InventoryUI inv = new InventoryUI(true);
                            }
                        });

                    }
                });
                editButton.setBounds(200, 100, 100, 50);
                removeButton.setBounds(200, 100, 100, 50);
                tempPanel.add(editButton);
                tempPanel.add(removeButton);
            } else
            {
                JButton addToCartButton = new JButton("Add");
                JButton viewDetailsButton = new JButton("View");
                addToCartButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Cart cart = Cart.getInstance();
                        Boolean exists = checkCartForItem(value);
                        if(!exists){
                        System.out.println("added");
                        cart.addItem(value);
                        }
                        System.out.println(cart.size());
                    }
                });
                addToCartButton.setBounds(200, 100, 100, 50);
                viewDetailsButton.setBounds(200, 100, 100, 50);
                tempPanel.add(addToCartButton);
                tempPanel.add(viewDetailsButton);
                viewDetailsButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        ProductUI p1 = new ProductUI(value, userType);
                        p1.viewFullProductDetails();
                    }
                });
            }
            tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            pUI.add(tempPanel);
        });
        for (int i = 0; i < pUI.size(); i++)
        {
            panel2.add(pUI.get(i));
        }
        panel1.setPreferredSize(new Dimension(100, 65));
        JScrollPane scrollPane = new JScrollPane(panel2, 20, 30);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(scrollPane);

        this.add(pane);
        panel1.setBackground(Color.blue);
        this.add(scrollPane);
        this.add(panel1, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

     @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==comboBox) {
   String order = comboBox.getSelectedItem().toString();
   switch(order) {
  case "Name asc" -> {
      inv.sortByNameAsc();
          }
  case "Name dsc" -> {
      inv.sortByNameDesc();
          }
  case "Price asc" -> {
      inv.sortByPriceAsc();
          }
  case "Price dsc" -> {
      inv.sortByPriceDesc();
          }
  default -> {
      break;
          }
}
   dispose();
   InventoryUI newUI = new InventoryUI(userAccess);
  }
 }
 
 private Boolean checkCartForItem(Product value){
   Cart cart = Cart.getInstance();
   Iterator<Product> it = cart.getCartItems();
   Boolean exists = false;

   while(it.hasNext()) {
          if(it.next().equals(value)){
             System.out.println("already in the cart");
              exists = true;
              break;
            }
          if(it.hasNext()) {
            it.next();
           }
      }
   return exists;
 }
}
