package cop4331.sorters;

import cop4331.client.Product;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Hunter B.
 */
public class SorterByPrice implements Comparator<Map.Entry<Integer, Product>>
{

    @Override
    public int compare(Map.Entry<Integer, Product> o1, Map.Entry<Integer, Product> o2)
    {
        double p1 = o1.getValue().getPrice();
        double p2 = o2.getValue().getPrice();
        return Double.compare(p1, p2);
    }
}
