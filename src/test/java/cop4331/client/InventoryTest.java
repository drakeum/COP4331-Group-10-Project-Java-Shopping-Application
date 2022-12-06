package cop4331.client;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Hunter B.
 */
class InventoryTest
{

    @Test
    void sortByPriceAsc()
    {
        System.out.println("Testing sorting inventory by price, ascending");
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
        System.out.println("Testing sorting inventory by price, descending");
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
    void sortByNameAsc()
    {
        System.out.println("Testing sorting inventory by name, ascending");
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

        Inventory.getInstance().sortByNameAsc();

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
        Product prod = new Product(1, "Apple", 10, 2.35, 3.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(3, "Bunny", 1, 1.35, 200.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(5, "Can", 1, 1.35, 0.5);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(2, "Orange", 15, 1.35, 2.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(4, "Pineapple", 5, 2.35, 2.40);
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
    void sortByNameDesc()
    {
        System.out.println("Testing sorting inventory by name, descending");
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

        Inventory.getInstance().sortByNameDesc();

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
        Product prod = new Product(4, "Pineapple", 5, 2.35, 2.40);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(2, "Orange", 15, 1.35, 2.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(5, "Can", 1, 1.35, 0.5);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(3, "Bunny", 1, 1.35, 200.00);
        sortCheck.put(prod.getId(), prod);
        prod = new Product(1, "Apple", 10, 2.35, 3.00);
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

    /*NOTE: There isn't a test for save() or load(), as these methods are called by every relevant mutating method
    saves the inventory after each change, so it isn't possible to have the inventory NOT save in order to have a
    control check against a saved inventory
    */
    @Test
    void removeProduct()
    {
        System.out.println("Testing removing item from inventory");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        Inventory.getInstance().addProduct(2, "Orange", 15, 1.35, 2.00);
        Inventory.getInstance().addProduct(4, "Pineapple", 5, 2.35, 2.40);
        Inventory.getInstance().addProduct(3, "Bunny", 1, 1.35, 200.00);
        Inventory.getInstance().addProduct(5, "Can", 1, 1.35, 0.5);

        System.out.println("Before item removal:");
        Set<Map.Entry<Integer, Product>> preRemove = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: preRemove)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        Inventory.getInstance().removeProduct(4);

        System.out.println("After removal:");
        Set<Map.Entry<Integer, Product>> postRemove = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: postRemove)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        assertFalse(Inventory.getInstance().getProductList().containsKey(4));
    }

    @Test
    void addProduct()
    {
        System.out.println("Testing adding item to inventory");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        Inventory.getInstance().addProduct(2, "Orange", 15, 1.35, 2.00);
        Inventory.getInstance().addProduct(3, "Bunny", 1, 1.35, 200.00);
        Inventory.getInstance().addProduct(5, "Can", 1, 1.35, 0.5);
        Inventory.getInstance().removeProduct(4);

        System.out.println("Before item addition:");
        Set<Map.Entry<Integer, Product>> preRemove = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: preRemove)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        Inventory.getInstance().addProduct(4, "Pineapple", 5, 2.35, 2.40);

        System.out.println("After addition:");
        Set<Map.Entry<Integer, Product>> postRemove = Inventory.getInstance().getProductList().entrySet();
        for(Map.Entry<Integer, Product> entry: postRemove)
        {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getPrice());
        }

        assertTrue(Inventory.getInstance().getProductList().containsKey(4));

    }

    @Test
    void editProduct()
    {
        System.out.println("Testing editing item in inventory:");
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        System.out.println("Item pre-edit:");

        System.out.println("Id: " + Inventory.getInstance().getProductList().get(1).getId() + " - Name: " + Inventory.getInstance().getProductList().get(1).getName() + " - Quantity: " + Inventory.getInstance().getProductList().get(1).getQuantity() + " - Cost: " + Inventory.getInstance().getProductList().get(1).getCost() + " - Price: " + Inventory.getInstance().getProductList().get(1).getPrice());

        Inventory.getInstance().editProduct(1, "Apple Edit", 11, 2.85, 3.00, 0);
        System.out.println("Item post-edit:");
        System.out.println("Id: " + Inventory.getInstance().getProductList().get(1).getId() + " - Name: " + Inventory.getInstance().getProductList().get(1).getName() + " - Quantity: " + Inventory.getInstance().getProductList().get(1).getQuantity() + " - Cost: " + Inventory.getInstance().getProductList().get(1).getCost() + " - Price: " + Inventory.getInstance().getProductList().get(1).getPrice());

        assertEquals("Apple Edit", Inventory.getInstance().getProductList().get(1).getName());
        assertEquals(0, Integer.compare(Inventory.getInstance().getProductList().get(1).getQuantity(), 11));
        assertEquals(0, Double.compare(Inventory.getInstance().getProductList().get(1).getCost(), 2.85));
        assertEquals(0, Double.compare(Inventory.getInstance().getProductList().get(1).getPrice(), 3.00));
    }
}