package cop4331.client;

import cop4331.gui.InventoryUI;

/**
 * @author Hunter B.
 */
public class StoreTester
{
    public static void main(String[] args)
    {
        Inventory inv1 = new Inventory();
        inv1.addProduct(10, "car", 20, 15, 80);
        InventoryUI invUI = new InventoryUI(inv1, false);
    }
}
