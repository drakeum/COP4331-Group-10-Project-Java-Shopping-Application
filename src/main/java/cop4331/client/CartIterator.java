package cop4331.client;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Hunter B.
 */
public class CartIterator implements Iterator<Product>
{
    private int current = 0;
    private ArrayList<Product> cartItems;

    public CartIterator(ArrayList<Product> cartItems)
    {
        this.cartItems = cartItems;
    }

    @Override
    public boolean hasNext()
    {
        return current < cartItems.size();
    }

    @Override
    public Product next()
    {
        return cartItems.get(current++);
    }
}
