package cop4331.client;

import java.io.*;

/**
 * Stores and manipulates the store's costs, revenue, and profits. This class is a singleton and is serializable
 *
 * @author Hunter B.
 */
public class StoreInfo implements Serializable
{
    private double totalCosts;
    private double totalRevenue;
    private double totalProfits;

    /**
     * Constructor for StoreInfo. The constructor is private because the class is a singleton
     */
    private StoreInfo()
    {

    }

    /**
     * Loads data from a serialized file called "storeinfo.dat" in to the current store info, setting the state of the store info
     * (costs, revenue, and profits) equal to that of the serialized file being read
     *
     * @throws IOException            if there are any of the usual Input/Output related exceptions
     * @throws ClassNotFoundException if class of a serialized object cant be found
     */
    public void load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("storeinfo.dat"));
        instance = (StoreInfo) in.readObject();
        in.close();
    }

    /**
     * Saves the current state of the store's info (costs, revenue, and profits) via serialization in to a file called "storeinfo.dat"
     *
     * @throws IOException if there are any of the usual Input/Output related exceptions
     */
    public void save() throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("storeinfo.dat"));
        out.writeObject(instance);
        out.close();
    }

    /**
     * Adds an amount of a product to the inventory (buys more of the product for the store), adds its cost * amount to the
     * store's costs and saves the state of StoreInfo
     *
     * @param prod   the product being bought
     * @param amount the amount of the product to add to inventory
     * @precondition amount > 0
     * @postcondition prod.getQuantity() >= 1
     */
    public void buyProductForStore(Product prod, int amount)
    {
        assert amount > 0 : "violated precondition amount > 0";
        totalCosts += (prod.getCost() * amount);
        int prevQuantity = prod.getQuantity();
        Inventory.getInstance().editProduct(prod.getId(), prod.getName(), prevQuantity + amount, prod.getCost(), prod.getPrice(), 0);
        try
        {
            save();
        } catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes one of a product from the inventory (sells the product the buyer) and adds its cost to the store's revenue
     * and saves the state of StoreInfo
     *
     * @param prod the product to be sold
     */
    public void sellProduct(Product prod, int amountToBeSold)
    {
        totalRevenue += (prod.getPrice() * amountToBeSold);
        int prevQuantity = prod.getQuantity();
        Inventory.getInstance().editProduct(prod.getId(), prod.getName(), prevQuantity - amountToBeSold, prod.getCost(), prod.getPrice(), 0);
        try
        {
            save();
        } catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Calculates the store's current profits and saves the state of StoreInfo
     */
    public void calculateProfits()
    {
        totalProfits = totalRevenue - totalCosts;
        try
        {
            save();
        } catch (IOException e)
        {
            System.out.println("IOException occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter for the total costs of the store
     *
     * @return the total costs of the store
     */
    public double getTotalCosts()
    {
        return totalCosts;
    }

    /**
     * Getter for the total revenue of the store
     *
     * @return the total revenue of the store
     */
    public double getTotalRevenue()
    {
        return totalRevenue;
    }

    /**
     * Getter for the total profits of the store
     *
     * @return the total profits of the store
     */
    public double getTotalProfits()
    {
        return totalProfits;
    }

    /**
     * Resets the store's sales information to 0 for each value
     */
    public void resetStoreInfo()
    {
        totalCosts = 0;
        totalRevenue = 0;
        totalProfits = 0;
    }

    /**
     * Getter method for the instance of the StoreInfo class
     *
     * @return the instance of StoreInfo
     */
    public static StoreInfo getInstance()
    {
        return instance;
    }

    /**
     * Instantiates the one global instance of StoreInfo, making it a singleton
     */
    private static StoreInfo instance = new StoreInfo();
}
