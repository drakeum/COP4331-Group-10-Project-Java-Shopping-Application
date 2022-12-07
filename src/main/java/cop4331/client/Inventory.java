package cop4331.client;
import cop4331.sorters.SorterByName;
import cop4331.sorters.SorterByPrice;

import java.io.*;
import java.util.*;

/**
 * Represents the inventory of the store. Stores products within it. This class is a singleton and is serializable
 * @author Hunter B.
 */
public class Inventory implements Serializable
{
    private LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();

    /**
     * Constructor for Inventory. The constructor is private because the class is a singleton
     */
    private Inventory() 
    {
    
    }

    /**
     * Getter method for the Inventory's product list
     * @return a map of products in the inventory
     */
    public LinkedHashMap<Integer, Product> getProductList()
    {
        return productList;
    }

    /**
     * Sorts the Inventory by product price, ascending
     */
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
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }


    /**
     * Sorts the inventory by product price, descending
     */
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
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Sorts the inventory by product name lexicographically, ascending
     */
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
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Sorts the inventory by product name lexicographically, descending
     */
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
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter method for the inventory's size
     * @return the amount of products in the inventory
     */
    public int size()
    {
        return productList.size();
    }

    /**
     * Loads data from a serialized file called "inventory.dat" in to the current inventory, setting the state of the inventory
     * (all the products it contains) equal to that of the serialized file being read
     * @throws IOException if there are any of the usual Input/Output related exceptions
     * @throws ClassNotFoundException if class of a serialized object cant be found
     */
    public void load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventory.dat"));
        instance = (Inventory) in.readObject();
        in.close();
    }

    /**
     * Saves the current state of the inventory (all products it contains) via serialization in to a file called "inventory.dat"
     * @throws IOException if there are any of the usual Input/Output related exceptions
     */
    public void save() throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
        out.writeObject(instance);
        out.close();
    }

    /**
     * Removes a product from the inventory and saves the state of Inventory
     * @param id the id of the product to remove
     * @precondition id >= 0
     * @postcondition  productList.size() = productList.size() - 1
     */
    public void removeProduct(int id) throws NoSuchElementException
    {
        assert id >= 0 : "violated precondition id >= 0";
        if(!productList.containsKey(id))
        {
            System.out.println("No product with id " + id + " was found in the inventory");
            throw new NoSuchElementException();
        }
        productList.remove(id);
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a product to the inventory, buys the amount added for the store, and saves the state of Inventory
     * @param id the id of the product to add
     * @param name the name of the product to add
     * @param quantity the quantity of the product to add
     * @param cost the cost of the product to add
     * @param price the price of the product to add
     * @precondition id >= 0, quantity >= 0, cost >= 0, price >= 0
     * @postcondition productList > 0
     */
    public void addProduct(int id, String name, int quantity, double cost, double price)
    {
        assert id >= 0 && quantity >= 0 && cost >= 0 && price >= 0 : "violated precondition id >= 0, quantity >= 0, cost >= 0, price >= 0";
        Product newProduct = new Product(id, name, 0, cost, price);
        productList.put(newProduct.getId(), newProduct);
        StoreInfo.getInstance().buyProductForStore(newProduct, quantity);
        newProduct.setQuantity(quantity);
        System.out.println("Added new product to inventory and bought " + newProduct.getQuantity() + " of it for cost " + newProduct.getCost() + " each");
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }


    /**
     * Edits the information of a product in the inventory (except the id) and saves the state of Inventory
     * @param id the id of the product to edit
     * @param name the edited name of the product
     * @param quantity the edited quantity of the product
     * @param cost the edited cost of the product
     * @param price the edited price of the product
     * @param amountToBeSold the amount of the item that will be sold (for use with Cart methods)
     * @precondition id >= 0, quantity >= 0, cost >= 0, price >= 0, amountToBeSold >= 0
     */
    public void editProduct(int id, String name, int quantity, double cost, double price, int amountToBeSold) throws NoSuchElementException
    {
        assert id >= 0 && quantity >= 0 && cost >= 0 && price >= 0 && amountToBeSold >= 0 : "violated precondition id >= 0, quantity >= 0, cost >= 0, price >= 0, amountToBeSold >= 0";
        if(!productList.containsKey(id))
        {
            System.out.println("No product with id " + id + " was found in the inventory");
            throw new NoSuchElementException();
        }
        Product editedProduct = new Product(id, name, quantity, cost, price);
        editedProduct.setAmountToBeSold(amountToBeSold);
        productList.replace(id, editedProduct);
        try
        {
            save();
        }
        catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter method for the instance of the Inventory class
     * @return the instance of Inventory
     */
    public static Inventory getInstance()
    {
        return instance;
    }

    /**
     * Instantiates the one global instance of Inventory, making it a singleton
     */
    private static Inventory instance = new Inventory();
}
