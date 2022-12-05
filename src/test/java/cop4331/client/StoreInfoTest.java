package cop4331.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hunter B.
 */
class StoreInfoTest
{

    @Test
    void save()
    {
        System.out.println("Testing saving store info:");
        Product prod = new Product(1, "Apple", 10, 2.35, 3.00);
        StoreInfo.getInstance().buyProductForStore(prod, 5);

    }

    @Test
    void buyProductForStore()
    {
    }

    @Test
    void sellProduct()
    {
    }

    @Test
    void calculateProfits()
    {
    }

    @Test
    void getTotalCosts()
    {
    }

    @Test
    void getTotalRevenue()
    {
    }

    @Test
    void getTotalProfits()
    {
    }
}