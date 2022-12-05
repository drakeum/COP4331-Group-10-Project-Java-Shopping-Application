package cop4331.client;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a buyer's cart. Stores the items a buyer wants to buy and manipulates the inventory and store's info accordingly
 * when a buyer confirms their purchase. This class is a singleton
 * @author Hunter B.
 */
public class Cart
{
    private ArrayList<Product> productList = new ArrayList<>();
    double totalPayment;

    /**
     * Constructor for the cart
     */
    private Cart()
    {

    }

    /**
     * Creates a CartIterator iterate over items in cart's productList with
     * @return a CartIterator for productList
     */
    public Iterator<Product> getCartItems()
    {
        return new CartIterator(productList);
    }

    /**
     * Adds a product to the cart
     * @param prod the product to add
     */
    public void addItem(Product prod)
    {
        productList.add(prod);
        prod.setAmountToBeSold(1);
        updateTotalPayment();
    }

    /**
     * Changes the amount of a product a customer has put in the cart
     * @param id the id of the product being sold
     * @param amountToBeSold the amount of the product the customer wants to buy
     * @precondition amountToBeSold >= 1
     */
    public void changeItemAmountToBeSold(int id, int amountToBeSold)
    {
        assert amountToBeSold >= 1 : "violated precondition amountToBeSold >= 1";
        Iterator<Product> iter = getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            if (currentProd.getId() == id)
            {
                currentProd.setAmountToBeSold(amountToBeSold);

            }
        }
        updateTotalPayment();
    }

    /**
     * Removes a product from the cart
     * @param id the id of the product to remove from the cart
     */
    public void removeItem(int id)
    {
        Iterator<Product> iter = getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            if(currentProd.getId() == id)
            {
                currentProd.setAmountToBeSold(0);
                productList.remove(currentProd);
            }
        }
        updateTotalPayment();
    }

    /**
     * Confirms the buyer's cart. Simulates the buyer purchasing the items and modifies the inventory and store info accordingly
     */
    public void confirmCart()
    {
        Iterator<Product> iter = getCartItems();
        Product currProd = iter.next();
        while(iter.hasNext())
        {
            StoreInfo.getInstance().sellProduct(currProd, currProd.getAmountToBeSold());
        }
    }

    /**
     * Updates the cart total the buyer will have to pay when they checkout
     */
    public void updateTotalPayment()
    {
        totalPayment = 0;
        Iterator<Product> iter = getCartItems();
        Product currProd = iter.next();
        while(iter.hasNext())
        {
            totalPayment += (currProd.getPrice() * currProd.getAmountToBeSold());
        }
    }

    /**
     * Getter method for the total cost of the items in the cart
     * @return the total cost of the items in the cart
     */
    public double getTotalPayment()
    {
        return totalPayment;
    }

    /**
     * Getter method for the instance of the Cart class
     * @return the instance of Cart
     */
    public static Cart getInstance()
    {
        return instance;
    }

    /**
     * Instantiates the one global instance of Cart, making it a singleton
     */
    private static Cart instance = new Cart();
}
