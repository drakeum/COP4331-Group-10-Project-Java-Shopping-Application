package cop4331.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Hunter B.
 */
class CartTest
{
    @BeforeEach
    void setUp()
    {
        Inventory.getInstance().addProduct(1, "Apple", 10, 2.35, 3.00);
        Inventory.getInstance().addProduct(2, "Orange", 15, 1.35, 2.00);
        Inventory.getInstance().addProduct(4, "Pineapple", 5, 2.35, 2.40);
        Inventory.getInstance().addProduct(3, "Bunny", 1, 1.35, 200.00);
        Inventory.getInstance().addProduct(5, "Can", 1, 1.35, 0.5);
    }

    @Test
    void getCartItems()
    {
        Cart.getInstance().emptyCart();
        System.out.println("Testing custom cart iterator:");
        ArrayList<Product> testCart = new ArrayList<>();
        testCart.add(Inventory.getInstance().getProductList().get(2));
        testCart.add(Inventory.getInstance().getProductList().get(4));
        testCart.add(Inventory.getInstance().getProductList().get(5));

        ArrayList<Product> testCart2 = new ArrayList<>();

        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(4));
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(5));
        System.out.println("Items in the cart:");
        Iterator<Product> iter = Cart.getInstance().getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            testCart2.add(currentProd);
            System.out.println("Id: " + currentProd.getId() + " - Name: " + currentProd.getName() + " - Quantity: " + currentProd.getQuantity() + " - Cost: " + currentProd.getCost() + " - Price: " + currentProd.getPrice() + " - Amount to be sold: " + currentProd.getAmountToBeSold());
        }

        assertEquals(testCart, testCart2);
    }

    @Test
    void addItem()
    {
        System.out.println("Testing adding item to cart:");

        Cart.getInstance().emptyCart();
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        assertEquals(1, Cart.getInstance().size());

    }

    @Test
    void changeItemAmountToBeSold()
    {
        System.out.println("Testing changing amount of item in cart:");
        Cart.getInstance().emptyCart();
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        Iterator<Product> iter = Cart.getInstance().getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            System.out.println("Amount of item in cart when first added: " + currentProd.getAmountToBeSold());
        }

        Cart.getInstance().changeItemAmountToBeSold(2, 4);
        int testAmount = 0;
        iter = Cart.getInstance().getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            System.out.println("Amount of item in cart after change: " + currentProd.getAmountToBeSold());
            testAmount = currentProd.getAmountToBeSold();
        }
        assertEquals(4, testAmount);
    }

    @Test
    void removeItem()
    {
        System.out.println("Testing removing an item from the cart: ");
        Cart.getInstance().emptyCart();
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(4));
        System.out.println("Items in the cart before removal:");
        Iterator<Product> iter = Cart.getInstance().getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            System.out.println("Id: " + currentProd.getId() + " - Name: " + currentProd.getName() + " - Quantity: " + currentProd.getQuantity() + " - Cost: " + currentProd.getCost() + " - Price: " + currentProd.getPrice() + " - Amount to be sold: " + currentProd.getAmountToBeSold());
        }
        Cart.getInstance().removeItem(2);

        System.out.println("Items in the cart after removal:");
        iter = Cart.getInstance().getCartItems();
        while(iter.hasNext())
        {
            Product currentProd = iter.next();
            System.out.println("Id: " + currentProd.getId() + " - Name: " + currentProd.getName() + " - Quantity: " + currentProd.getQuantity() + " - Cost: " + currentProd.getCost() + " - Price: " + currentProd.getPrice() + " - Amount to be sold: " + currentProd.getAmountToBeSold());
            assertEquals(currentProd, Inventory.getInstance().getProductList().get(4));
        }
    }

    @Test
    void confirmCart()
    {
        Cart.getInstance().emptyCart();
        System.out.println("Store info after seller buys items for store: ");
        System.out.println("Costs: " + StoreInfo.getInstance().getTotalCosts());
        System.out.println("Revenue: " + StoreInfo.getInstance().getTotalRevenue());
        System.out.println("Profits: " + StoreInfo.getInstance().getTotalProfits());

        System.out.println("Buyer adds one orange, 4 pineapples, and one bunny to their cart.");
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(4));
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(3));
        Cart.getInstance().changeItemAmountToBeSold(4, 4);
        Cart.getInstance().confirmCart();

        System.out.println("Store info after buyer confirms cart and purchases items: ");
        System.out.println("Costs: " + StoreInfo.getInstance().getTotalCosts());
        System.out.println("Revenue: " + StoreInfo.getInstance().getTotalRevenue());
        System.out.println("Profits: " + StoreInfo.getInstance().getTotalProfits());

        assertEquals(211.6, StoreInfo.getInstance().getTotalRevenue());
        assertEquals(153.39999999999998, StoreInfo.getInstance().getTotalProfits());
    }

    @Test
    void updateTotalPayment()
    {
        System.out.println("Testing updating total cart payment: ");
        Cart.getInstance().emptyCart();
        System.out.println("Cart total before adding items: " + Cart.getInstance().getTotalPayment());
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(2));
        System.out.println("Cart total after adding an orange: " + Cart.getInstance().getTotalPayment());
        Cart.getInstance().addItem(Inventory.getInstance().getProductList().get(4));
        Cart.getInstance().changeItemAmountToBeSold(4, 3);
        System.out.println("Cart total after adding 3 pineapples: " + Cart.getInstance().getTotalPayment());
        assertEquals(9.2, Cart.getInstance().getTotalPayment());
    }
}