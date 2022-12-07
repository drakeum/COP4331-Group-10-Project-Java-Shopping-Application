package cop4331.gui;

import cop4331.client.Cart;
import cop4331.client.CartIterator;
import cop4331.client.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * @author Tommy Las 
 */
public class CartUI extends JFrame {
    private Cart cart = Cart.getInstance();
    public CartUI() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("Cart");
        this.setLocation(400, 100);
        this.setResizable(false);
        this.setSize(400,650);

        JLabel title = new JLabel();
        
        JButton returnButton = new JButton("Return");
        
        returnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  new InventoryUI(false); 
                  dispose();
               }
            }
         );

        JPanel cartProducts = new JPanel(new GridLayout(cart.size(), 1));
        if(cart.size() < 1){
            title.setText("Cart is Empty!");
            title.setFont(new Font("Calibri", Font.BOLD, 20));
            this.add(title);
            this.add(returnButton);
        }
        else{
            title.setText("Cart Items:");
            title.setFont(new Font("Calibri", Font.BOLD, 20));
            this.add(title);

            JLabel totalPrice = new JLabel("Total Price: $" + String.format("%.2f", cart.getTotalPayment()));

            Iterator cartIterator = cart.getCartItems();

            while(cartIterator.hasNext()){
                Product product = (Product) cartIterator.next();

                JPanel productPanel = new JPanel(null);
                productPanel.setPreferredSize(new Dimension(390, 30));
                productPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                productPanel.setBackground(new Color(210, 210, 210));

                JTextField quantity = new JTextField(String.valueOf(product.getAmountToBeSold()));
                quantity.setBounds(5,5,40, 20);
                quantity.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * @author Tommy L., Hunter B
                         */
                        if(Integer.parseInt(quantity.getText().trim()) > product.getQuantity())
                        {
                            System.out.println("Can't sell this much of the item, not enough in stock");
                            quantity.setText(String.valueOf(product.getQuantity()));
                        }
                        else
                        {
                            cart.changeItemAmountToBeSold(product.getId(), Integer.parseInt(quantity.getText().trim()));
                            System.out.println("amount to be sold changed to: " + quantity.getText().trim());
                            totalPrice.setText("Total Price: $" + String.format("%.2f", cart.getTotalPayment()));
                        }

                    }
                }
                );
                /**
                 * @author Tommy L.
                 */
                JLabel productLabel = new JLabel(product.getName() + " - $" + product.getPrice());
                productLabel.setBounds(55,5,100, 20);

                JButton removeButton = new JButton("x");
                removeButton.setMargin(new Insets(0, 0, 0, 0));
                //removeButton.setForeground(Color.white);
                removeButton.setBounds(360, 5, 17, 17);
                removeButton.setBackground(Color.red);

                //remove item from cart & update cart
                removeButton.addActionListener((e) -> {
                    int confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to remove this item?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
                    
                    if(confirm == 0){
                        cart.removeItem(product.getId());
                        new CartUI();
                        this.dispose();
                    }

                });

                productPanel.add(quantity);
                productPanel.add(productLabel);
                productPanel.add(removeButton);

                cartProducts.add(productPanel);
            }

            JButton payButton = new JButton("Pay");
            payButton.addActionListener(e->{
                new PaymentUI(cart.getTotalPayment());
                this.dispose();
            });

            this.add(cartProducts);
            this.add(totalPrice);
            this.add(payButton);
            this.add(returnButton);
        }
        this.setVisible(true);
    }
}
