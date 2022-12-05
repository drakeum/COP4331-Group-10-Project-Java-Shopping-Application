package cop4331.client;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterates over Products in the cart
 * @author Hunter B.
 */
public class CartIterator implements Iterator<Product>
{
    private int current = 0;
    private ArrayList<Product> cartItems;

    /**
     * Constructor for the iterator
     * @param cartItems a list of Products (the cart) to iterate over
     */
    public CartIterator(ArrayList<Product> cartItems)
    {
        this.cartItems = cartItems;
    }

    /**
     * Checks if there is another Product to iterate over in the cart
     * @return false if the iterator has reached the end of the cart; true if the iterator has not reached the end of the cart
     */
    @Override
    public boolean hasNext()
    {
        return current < cartItems.size();
    }

    /**
     * Returns the Product at the iterator's current position and moves the iterator's current position up by one
     * @return the Product at the iterator's current position
     */
    @Override
    public Product next()
    {
        return cartItems.get(current++);
    }
}
