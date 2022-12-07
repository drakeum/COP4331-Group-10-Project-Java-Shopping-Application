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
        if(prod.getQuantity() > 0)
        {
            prod.setAmountToBeSold(1);
        }
        else
        {
            prod.setAmountToBeSold(0);
        }
        updateTotalPayment();
    }

    /**
     * Changes the amount of a product a customer has put in the cart
     * @param id the id of the product being sold
     * @param amountToBeSold the amount of the product the customer wants to buy
     * @precondition amountToBeSold >= 1 && amountToBeSold <= Inventory.getInstance().getProductList().get(id).getQuantity()
     */
    public void changeItemAmountToBeSold(int id, int amountToBeSold)
    {
        assert amountToBeSold >= 1 && amountToBeSold <= Inventory.getInstance().getProductList().get(id).getQuantity(): "violated precondition amountToBeSold >= 1 && amountToBeSold <= Inventory.getInstance().getProductList().get(id).getQuantity()";
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
        while(iter.hasNext())
        {
            Product currProd = iter.next();
            StoreInfo.getInstance().sellProduct(currProd, currProd.getAmountToBeSold());
        }
        StoreInfo.getInstance().calculateProfits();
    }

    /**
     * Updates the cart total the buyer will have to pay when they check out
     */
    public void updateTotalPayment()
    {
        totalPayment = 0;
        if(size() == 0)
        {
            return;
        }
        Iterator<Product> iter = getCartItems();
        while(iter.hasNext())
        {
            Product currProd = iter.next();
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
     * Clears the cart of all items
     */
    public void emptyCart()
    {
        productList.clear();
        updateTotalPayment();
    }

    /**
     * Returns the amount of items in the cart
     * @return the amount of items in the cart
     */
    public int size()
    {
        return productList.size();
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
