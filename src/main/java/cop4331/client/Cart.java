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

    public void removeItem(int id)
    {
        Iterator<Product> iter = getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            if(currentProd.getId() == id)
            {
                totalPayment -= currentProd.getPrice();
                productList.remove(currentProd);
            }
        }
    }

    public void confirmCart()
    {
        Iterator<Product> iter = getCartItems();
        while(iter.hasNext())
        {
            StoreInfo.getInstance().sellProduct(iter.next());
        }
    }

    public double getTotalPayment()
    {
        return totalPayment;
    }

    public static Cart getInstance()
    {
        return instance;
    }

    private static Cart instance = new Cart();
}
