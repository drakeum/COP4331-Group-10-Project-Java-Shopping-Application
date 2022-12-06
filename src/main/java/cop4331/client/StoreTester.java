package cop4331.client;

import cop4331.gui.InventoryUI;

/**
 * @author Hunter B, Tommy L, Mark A
 */
public class StoreTester
{
    public static void main(String[] args)
    {

        Inventory.getInstance().addProduct(10, "car", 20, 15, 80);
        Inventory.getInstance().addProduct(12, "computer", 20, 15, 80);
        Inventory.getInstance().addProduct(14, "tv", 20, 15, 80);
        Inventory.getInstance().addProduct(15, "house", 20, 15, 80);
        Inventory.getInstance().addProduct(16, "house2", 20, 15, 80);
        Inventory.getInstance().addProduct(17, "house2", 20, 15, 80);
        Inventory.getInstance().addProduct(18, "house2", 20, 15, 80);
        
       // new LoginUI();
        InventoryUI invUI = new InventoryUI(false);
    }
}
