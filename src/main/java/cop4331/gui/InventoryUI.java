package cop4331.gui;

import cop4331.client.Cart;
import cop4331.client.Inventory;
import cop4331.client.Product;
import cop4331.client.StoreInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author Mark A.
 * a store inventory interface for both the seller and user, depending on who is logged in.
 * If the seller is logged in then they can edit and remove items.
 * Users can view items in detail and also add them to their cart.
 */
public class InventoryUI extends JFrame implements ActionListener
{

    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();

    private JButton cartButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton addItemButton = new JButton();
    private JButton storeInfoButton = new JButton();
    private Inventory inv;
    private JPanel pane = new JPanel();
    private JButton editButton = new JButton("Edit");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(new GridLayout(0, 2, 50, 50));
    private JComboBox comboBox;
    private Boolean userAccess;
    private JPanel panel3 = new JPanel();
    private String[] order = {"Name asc", "Name dsc", "Price asc", "Price dsc"};
    private Cart cart = Cart.getInstance();

    public InventoryUI(Boolean userType)
    {
        /**
         * @author Hunter B.
         */
        try
        {
            Inventory.getInstance().load();
        } catch (IOException | ClassNotFoundException e)
        {
            try
            {
                Inventory.getInstance().save();
            } catch (IOException e2)
            {
                System.out.println("IOException occurred");
                throw new RuntimeException(e);
            }
        }
        try
        {
            StoreInfo.getInstance().load();
        } catch (IOException | ClassNotFoundException e)
        {
            try
            {
                StoreInfo.getInstance().save();
            } catch (IOException e2)
            {
                System.out.println("IOException occurred");
                throw new RuntimeException(e);
            }
        }
        System.out.println("Current store stats: ");
        System.out.println("Costs: " + StoreInfo.getInstance().getTotalCosts());
        System.out.println("Revenues: " + StoreInfo.getInstance().getTotalRevenue());
        StoreInfo.getInstance().calculateProfits();
        System.out.println("Profits: " + StoreInfo.getInstance().getTotalProfits());
        /**
         * @author Mark A.
         */
        inv = Inventory.getInstance();
        userAccess = userType;
        if (!userType)
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
            
            /**
            * Button action listener that routes to the sales info UI
            */
            storeInfoButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    SalesInformationUI salesInfo = new SalesInformationUI();
                }
            });
            
            // Button action listener that routes to the add product UI
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


        // an ArrayList that stores the JPanels for the products
        ArrayList<JPanel> pUI = new ArrayList<>();
        
        // iterating through each product and adding it to the Jpanel Array list
        productList.forEach((key, value) ->
        {
            ProductUI p = new ProductUI(value, userType);
            JPanel tempPanel = p.getProductPanel();
            if (userType)
            {

                JButton editButton = new JButton("Edit");
                
                // Button action listener that routes to the edit product UI
                editButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        new EditProductUI(value);
                        dispose();
                    }

                });

                JButton removeButton = new JButton("Remove");
                  //remove item from cart & update cart
                removeButton.addActionListener((e) -> {
                    String text = "Are you sure you want to remove this item?";
                    String textType = "Confirmation";
                    ConfirmationUI conf = new ConfirmationUI(text, textType);
                    int confirm = conf.getSelection();
                   

                    //item removed, update the cart
                    if(confirm == 0){
                        inv.removeProduct(value.getId());
                        dispose();
                        new InventoryUI(true);
                    } else {
                        new InventoryUI(true);
                    }

                });
                editButton.setBounds(200, 100, 100, 50);
                removeButton.setBounds(200, 100, 100, 50);
                tempPanel.add(editButton);
                tempPanel.add(removeButton);
            } else
            {
                JButton addToCartButton = new JButton("Add");
                JButton addToCartFromViewButton = new JButton("Add");
                JButton viewDetailsButton = new JButton("View");
                
                // Button action listener that adds items to the cart and updates total payment from the detailed panel
                addToCartFromViewButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Boolean exists = checkCartForItem(value);
                        if (!exists)
                        {
                            cart.addItem(value);
                            cart.updateTotalPayment();
                        }
                    }
                });
                
                 // Button action listener that adds items to the cart
                addToCartButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Boolean exists = checkCartForItem(value);
                        if (!exists)
                        {
                            cart.addItem(value);
                        }
                    }
                });
                addToCartButton.setBounds(200, 100, 100, 50);
                viewDetailsButton.setBounds(200, 100, 100, 50);
                tempPanel.add(addToCartButton);
                tempPanel.add(viewDetailsButton);
                 // Button action listener that opens up a detailed panel containing more information about the product
                viewDetailsButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        ProductUI p1 = new ProductUI(value, userType);
                        panel3 = p1.viewFullProductDetails();
                        panel3.add(addToCartFromViewButton);
                    }
                });
            }
            tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            pUI.add(tempPanel);
        });
        
        // iterating through the productUI JPanels and adding it to the main panel.
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

     // action listener that sorts the products based off the selected drop down selection.
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == comboBox)
        {
            switch (comboBox.getSelectedItem().toString())
            {
                case "Name asc" ->
                {
                    inv.sortByNameAsc();
                }
                case "Name dsc" ->
                {
                    inv.sortByNameDesc();
                }
                case "Price asc" ->
                {
                    inv.sortByPriceAsc();
                }
                case "Price dsc" ->
                {
                    inv.sortByPriceDesc();
                }
                default ->
                {
                    break;
                }
            }
            dispose();
            new InventoryUI(userAccess);
        }
    }

    /**
     * checks to see if the item is already in the cart
     *
     * @return if the item is in the cart or not
     */
    private Boolean checkCartForItem(Product value)
    {

        Iterator<Product> it = cart.getCartItems();

        while (it.hasNext())
        {
            if (it.next().getId() == value.getId())
            {
                return true;
            }
        }
        return false;
    }

}
