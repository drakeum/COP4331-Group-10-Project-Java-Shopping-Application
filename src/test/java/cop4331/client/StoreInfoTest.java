package cop4331.client;

import org.junit.jupiter.api.Test;


/**
 * @author Hunter B.
 */
class StoreInfoTest
{

    /*NOTE: There isn't a test for save() or load(), as these methods are called by every relevant mutating method
    saves the store info after each change, so it isn't possible to have the store info NOT save in order to
    have a control check against a saved store info
    */
    @Test
    void buyProductForStore()
    {
        System.out.println("Testing buying more of a product for the store");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        System.out.println("Current amount of apple in the store before buying more: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store costs before buying more: " + StoreInfo.getInstance().getTotalCosts());
        StoreInfo.getInstance().buyProductForStore(Inventory.getInstance().getProductList().get(1), 5);
        System.out.println("Current amount of apple in the store after buying more: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store costs after buying more: " + StoreInfo.getInstance().getTotalCosts());

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