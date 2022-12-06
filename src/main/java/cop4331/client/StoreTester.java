package cop4331.client;

/**
 * @author Hunter B.
 */
public class StoreTester
{
    public static void main(String[] args)
    {
          Inventory inv = new Inventory();
          inv.addProduct(10,"Item1",15,13,20);
          inv.addProduct(20,"Item2",15,13,20);
          inv.addProduct(30,"Item3",15,13,20);
          inv.addProduct(40,"Item4",15,13,20);
          InventoryUI invUI = new InventoryUI(inv, false);
    }
}
