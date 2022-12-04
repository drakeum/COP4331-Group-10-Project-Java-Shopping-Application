package cop4331.client;

import java.io.Serializable;

/**
 * @author Hunter B.
 */
public class StoreInfo implements Serializable
{
    private double totalCosts;
    private double totalRevenue;
    private double totalProfits;

    public void buyProductForStore(Product prod)
    {
        totalCosts += prod.getCost();
    }

    public void sellProduct(Product prod)
    {
        totalRevenue += prod.getPrice();
    }

    public void calculateProfits()
    {
        totalProfits = totalRevenue - totalCosts;
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

}
