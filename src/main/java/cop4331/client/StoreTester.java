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

        inventory.addProduct(10, "car", 20, 15, 79);
        inventory.addProduct(12, "computer", 20, 15, 50);
        inventory.addProduct(14, "tv", 20, 15, 30);
        inventory.addProduct(15, "house", 20, 15, 20);
        inventory.addProduct(16, "house2", 20, 15, 10);
        inventory.addProduct(17, "house2", 20, 15, 40);
        inventory.addProduct(18, "house2", 20, 15, 11);
        
        //new LoginUI();
        InventoryUI ui1 = new InventoryUI(false);
    }
}
