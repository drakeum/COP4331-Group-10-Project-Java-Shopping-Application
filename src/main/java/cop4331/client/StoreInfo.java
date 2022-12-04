package cop4331.client;

import java.io.*;

/**
 * @author Hunter B.
 */
public class StoreInfo implements Serializable
{
    private double totalCosts;
    private double totalRevenue;
    private double totalProfits;

    private StoreInfo()
    {

    }

    public void load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("storeinfo.dat"));
        instance = (StoreInfo) in.readObject();
        in.close();
    }

    public void save() throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("storeinfo.dat"));
        out.writeObject(instance);
        out.close();
    }

    public void buyProductForStore(Product prod)
    {
        totalCosts += prod.getCost();
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

    public void sellProduct(Product prod)
    {
        totalRevenue += prod.getPrice();
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

    public void calculateProfits()
    {
        totalProfits = totalRevenue - totalCosts;
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

    public double getTotalCosts()
    {
        return totalCosts;
    }

    public double getTotalRevenue()
    {
        return totalRevenue;
    }

    public double getTotalProfits()
    {
        return totalProfits;
    }


    public static StoreInfo getInstance()
    {
        return instance;
    }

    private static StoreInfo instance = new StoreInfo();
}
