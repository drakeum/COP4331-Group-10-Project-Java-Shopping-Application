package cop4331.client;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Hunter B.
 */
class InventoryTest
{

    @Test
    void sortByPrice()
    {
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        Inventory.getInstance().addProduct(2, "Orange", 15, 1.35, 2.00);
        Inventory.getInstance().addProduct(4, "Pineapple", 5, 2.35, 2.40);
        Inventory.getInstance().addProduct(3, "Bunny", 1, 1.35, 200.00);
        Inventory.getInstance().addProduct(5, "Can", 1, 1.35, 0.5);

        System.out.println("Before sort:");
        Set<Map.Entry<Integer, Product>> preSort = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: preSort)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        Inventory.getInstance().sortByPrice();

        System.out.println("After sort:");
        Set<Map.Entry<Integer, Product>> postSort = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: postSort)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }



    }

    @Test
    void load()
    {
    }

    @Test
    public void save()
    {

        System.out.println("Testing save");
        //add example products to inventory
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        Inventory.getInstance().addProduct(2, "Orange", 15, 1.35, 2.00);
        System.out.println("Current inventory size after adding two products: " + Inventory.getInstance().size());
        //save the inventory through serialization
        try
        {
            Inventory.getInstance().save();
        } catch (IOException e)
        {
            System.out.println("IOException occurred");
        }

        //remove a product from the inventory
        Inventory.getInstance().removeProduct(1);
        int removedSize = Inventory.getInstance().size();
        System.out.println("Current inventory size after removing a product: " + Inventory.getInstance().size());

        //load the inventory to test if the products were saved
        try
        {
            Inventory.getInstance().load();
        } catch (IOException | ClassNotFoundException e)
        {
            System.out.println("IOException occurred");
        }

        int loadedSize = Inventory.getInstance().size();
        boolean productRemoved = removedSize == 1;
        boolean productsSaved = loadedSize == 2;

        //tests if a product was removed (needed to make sure size of inventory was 1 before it was loaded)
        assertTrue(productRemoved);
        //tests if inventory size was back to equaling 2 after load
        assertTrue(productsSaved);
    }

    @Test
    void removeProduct()
    {
    }

    @Test
    void addProduct()
    {
    }

    @Test
    void editProduct()
    {
    }
}