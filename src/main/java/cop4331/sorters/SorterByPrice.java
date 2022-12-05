package cop4331.sorters;

import cop4331.client.Product;

import java.util.Comparator;
import java.util.Map;

/**
 * Compares Products by product price
 * @author Hunter B.
 */
public class SorterByPrice implements Comparator<Map.Entry<Integer, Product>>
{
    /**
     * Compares two Product objects' prices
     * @param o1 the first Product to be compared.
     * @param o2 the second Product to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
     * greater than the second
     */
    @Override
    public int compare(Map.Entry<Integer, Product> o1, Map.Entry<Integer, Product> o2) throws NullPointerException
    {
        if(o1 == null || o2 == null)
        {
            System.out.println("Can't compare with a null Product");
            throw new NullPointerException();
        }
        double p1 = o1.getValue().getPrice();
        double p2 = o2.getValue().getPrice();
        return Double.compare(p1, p2);
    }
}
