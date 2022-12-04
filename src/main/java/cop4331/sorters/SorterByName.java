package cop4331.sorters;

import cop4331.client.Product;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Hunter B.
 */
public class SorterByName implements Comparator<Map.Entry<Integer, Product>>
{
    @Override
    public int compare(Map.Entry<Integer, Product> o1, Map.Entry<Integer, Product> o2)
    {
        String p1 = o1.getValue().getName();
        String p2 = o2.getValue().getName();
        return p1.compareTo(p2);
    }
}
