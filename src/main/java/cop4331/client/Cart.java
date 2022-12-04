package cop4331.client;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Hunter B.
 */
public class Cart
{
    private ArrayList<Product> productList = new ArrayList<>();
    double totalPayment;
    private Cart()
    {

    }

    public Iterator<Product> getCartItems()
    {
        return new CartIterator(productList);
    }

    public void addItem(Product prod)
    {
        productList.add(prod);
        totalPayment += prod.getPrice();
    }



    public static Cart getInstance()
    {
        return instance;
    }

    private static Cart instance = new Cart();
}
