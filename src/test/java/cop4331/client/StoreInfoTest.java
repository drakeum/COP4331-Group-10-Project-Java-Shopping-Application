package cop4331.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Hunter B.
 */
class StoreInfoTest
{

    /*NOTE: There isn't a test for save() or load(), as these methods are called by every relevant mutating method
    saves the store info after each change, so it isn't possible to have the store info NOT save in order to
    have a control check against a saved store info
    */

    /*NOTE 2: Testing with singleton classes is a little weird because if you run every test as a whole, then
    the same singleton is used throughout and can mess with the results. However, if you run each test
    individually, they work as they should. I have tried to make it so the tests work correctly regardless of how
    they are run, so there is some code that is seemingly unnecessary
    */
    @Test
    void buyProductForStore()
    {
        System.out.println("Testing buying more of a product for the store");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        System.out.println("Current amount of apples in the store before buying more: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store costs before buying more apples: " + StoreInfo.getInstance().getTotalCosts());
        StoreInfo.getInstance().buyProductForStore(Inventory.getInstance().getProductList().get(1), 5);
        System.out.println("Current amount of apples in the store after buying more: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store costs after buying more apples: " + StoreInfo.getInstance().getTotalCosts());
        assertEquals(35.25, StoreInfo.getInstance().getTotalCosts());
    }

    @Test
    void sellProduct()
    {
        StoreInfo.getInstance().resetStoreInfo();
        System.out.println("Testing selling a product from the store");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        System.out.println("Current amount of apples in the store before selling 8: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store revenue before selling 8 apples: " + StoreInfo.getInstance().getTotalRevenue());
        StoreInfo.getInstance().sellProduct(Inventory.getInstance().getProductList().get(1), 8);
        System.out.println("Current amount of apples in the store after selling 8: " + Inventory.getInstance().getProductList().get(1).getQuantity());
        System.out.println("Current store revenue after selling 8 apples: " + StoreInfo.getInstance().getTotalRevenue());

        assertEquals(24.0, StoreInfo.getInstance().getTotalRevenue());
    }

    @Test
    void calculateProfits()
    {
        StoreInfo.getInstance().resetStoreInfo();
        System.out.println("Testing calculating store profits:");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        StoreInfo.getInstance().calculateProfits();
        System.out.println("Profits before selling any apples: " + StoreInfo.getInstance().getTotalProfits());
        StoreInfo.getInstance().sellProduct(Inventory.getInstance().getProductList().get(1), 8);
        StoreInfo.getInstance().calculateProfits();
        System.out.println("Profits after selling 8 apples: " + StoreInfo.getInstance().getTotalProfits());
        assertEquals(0.5, StoreInfo.getInstance().getTotalProfits());
    }

}