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

        //new CartUI();
        new LoginUI();
        //new InventoryUI(false);

    }
}
