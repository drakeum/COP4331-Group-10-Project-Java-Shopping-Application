package cop4331.client;

import cop4331.gui.CartUI;
import cop4331.gui.InventoryUI;
import cop4331.gui.LoginUI;

/**
 * @author Hunter B, Tommy L, Mark A
 */
public class StoreTester
{
    public static void main(String[] args)
    {

        Inventory inventory = Inventory.getInstance();

        inventory.addProduct(10, "car", 20, 15, 80);
        inventory.addProduct(12, "computer", 20, 15, 80);
        inventory.addProduct(14, "tv", 20, 15, 80);
        inventory.addProduct(15, "house", 20, 15, 80);
        inventory.addProduct(16, "house2", 20, 15, 80);
        inventory.addProduct(17, "house2", 20, 15, 80);
        inventory.addProduct(18, "house2", 20, 15, 80);

        new CartUI();
        //new LoginUI();
        //InventoryUI ui1 = new InventoryUI(false);

    }
}
