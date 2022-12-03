package cop4331.client;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Hunter B.
 */
class InventoryTest
{

    @Test
    void sortByPriceAsc()
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

        Inventory.getInstance().sortByPriceAsc();

        System.out.println("After sort:");
        Set<Map.Entry<Integer, Product>> postSort = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: postSort)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        Set<Integer> postSortKeySet = Inventory.getInstance().getProductList().keySet();
        Integer[] postSortKeySetArr = new Integer[5];
        int i = 0;
        for(Integer entry: postSortKeySet)
        {
            postSortKeySetArr[i++] = entry;
        }

        LinkedHashMap<Integer, Product> sortCheck = new LinkedHashMap<>();
        Product prod = new Product(5, "Can", 1, 1.35, 0.5);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(2, "Orange", 15, 1.35, 2.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(4, "Pineapple", 5, 2.35, 2.40);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(1, "Apple", 10, 2.35, 3.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(3, "Bunny", 1, 1.35, 200.00);
        sortCheck.put(prod.getId(), prod);
        Set<Integer> sortCheckKeySet = sortCheck.keySet();
        Integer[] sortCheckKeySetArr = new Integer[5];
        int j = 0;
        for(Integer entry: sortCheckKeySet)
        {
            sortCheckKeySetArr[j++] = entry;
        }

        assertArrayEquals(postSortKeySetArr, sortCheckKeySetArr);

    }

    @Test
    void sortByPriceDesc()
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

        Inventory.getInstance().sortByPriceDesc();

        System.out.println("After sort:");
        Set<Map.Entry<Integer, Product>> postSort = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: postSort)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        Set<Integer> postSortKeySet = Inventory.getInstance().getProductList().keySet();
        Integer[] postSortKeySetArr = new Integer[5];
        int i = 0;
        for(Integer entry: postSortKeySet)
        {
            postSortKeySetArr[i++] = entry;
        }

        LinkedHashMap<Integer, Product> sortCheck = new LinkedHashMap<>();
        Product prod = new Product(3, "Bunny", 1, 1.35, 200.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(1, "Apple", 10, 2.35, 3.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(4, "Pineapple", 5, 2.35, 2.40);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(2, "Orange", 15, 1.35, 2.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(5, "Can", 1, 1.35, 0.5);
        sortCheck.put(prod.getId(), prod);
        Set<Integer> sortCheckKeySet = sortCheck.keySet();
        Integer[] sortCheckKeySetArr = new Integer[5];
        int j = 0;
        for(Integer entry: sortCheckKeySet)
        {
            sortCheckKeySetArr[j++] = entry;
        }

        assertArrayEquals(postSortKeySetArr, sortCheckKeySetArr);
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