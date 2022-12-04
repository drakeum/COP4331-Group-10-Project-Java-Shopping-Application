package cop4331.client;
import cop4331.sorters.SorterByName;
import cop4331.sorters.SorterByPrice;

import java.io.*;
import java.util.*;

/**
 * @author Hunter B.
 */
public class Inventory implements Serializable
{
    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();
    private Inventory()
    {

    }

    public LinkedHashMap<Integer, Product> getProductList()
    {
        return productList;
    }

    public void sortByPriceAsc()
    {
        //create the modified comparator
        SorterByPrice sorter = new SorterByPrice();
        //convert hashmap to set for sorting
        Set<Map.Entry<Integer, Product>> items = productList.entrySet();
        //convert set to list for sorting
        List<Map.Entry<Integer, Product>> itemList = new ArrayList<>(items);
        //sort the list by price
        itemList.sort(sorter);
        //make new hashmap to put sorted items in to
        LinkedHashMap<Integer, Product> sortedItems = new LinkedHashMap<>();
        for(Map.Entry<Integer, Product> item : itemList)
        {
            sortedItems.put(item.getKey(), item.getValue());
        }
        //set inventory equal to sorted hashmap
        productList = sortedItems;
    }

    public void sortByPriceDesc()
    {
        //create the modified comparator
        SorterByPrice sorter = new SorterByPrice();
        //convert hashmap to set for sorting
        Set<Map.Entry<Integer, Product>> items = productList.entrySet();
        //convert set to list for sorting
        List<Map.Entry<Integer, Product>> itemList = new ArrayList<>(items);
        //sort the list by price
        itemList.sort(sorter);
        //reverse the sorting
        Collections.reverse(itemList);
        //make new hashmap to put sorted items in to
        LinkedHashMap<Integer, Product> sortedItems = new LinkedHashMap<>();
        for(Map.Entry<Integer, Product> item : itemList)
        {
            sortedItems.put(item.getKey(), item.getValue());
        }
        //set inventory equal to sorted hashmap
        productList = sortedItems;
    }

    public void sortByNameAsc()
    {
        //create the modified comparator
        SorterByName sorter = new SorterByName();
        //convert hashmap to set for sorting
        Set<Map.Entry<Integer, Product>> items = productList.entrySet();
        //convert set to list for sorting
        List<Map.Entry<Integer, Product>> itemList = new ArrayList<>(items);
        //sort the list by name
        itemList.sort(sorter);
        //make new hashmap to put sorted items in to
        LinkedHashMap<Integer, Product> sortedItems = new LinkedHashMap<>();
        for(Map.Entry<Integer, Product> item : itemList)
        {
            sortedItems.put(item.getKey(), item.getValue());
        }
        //set inventory equal to sorted hashmap
        productList = sortedItems;
    }

    public void sortByNameDesc()
    {
        //create the modified comparator
        SorterByName sorter = new SorterByName();
        //convert hashmap to set for sorting
        Set<Map.Entry<Integer, Product>> items = productList.entrySet();
        //convert set to list for sorting
        List<Map.Entry<Integer, Product>> itemList = new ArrayList<>(items);
        //sort the list by name
        itemList.sort(sorter);
        //reverse the sorting
        Collections.reverse(itemList);
        //make new hashmap to put sorted items in to
        LinkedHashMap<Integer, Product> sortedItems = new LinkedHashMap<>();
        for(Map.Entry<Integer, Product> item : itemList)
        {
            sortedItems.put(item.getKey(), item.getValue());
        }
        //set inventory equal to sorted hashmap
        productList = sortedItems;
    }

    public int size()
    {
        return productList.size();
    }
    public void load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventory.dat"));
        instance = (Inventory) in.readObject();
        in.close();
    }

    public void save() throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
        out.writeObject(instance);
        out.close();
    }

    public void removeProduct(int id)
    {
        productList.remove(id);
    }

    public void addProduct(int id, String name, int quantity, double cost, double price)
    {
        Product newProduct = new Product(id, name, quantity, cost, price);
        productList.put(newProduct.getId(), newProduct);
    }

    public void editProduct(int id, String name, int quantity, double cost, double price)
    {
        Product editedProduct = new Product(id, name, quantity, cost, price);
        productList.replace(id, editedProduct);
    }

    public static Inventory getInstance()
    {
        return instance;
    }

    private static Inventory instance = new Inventory();
}
