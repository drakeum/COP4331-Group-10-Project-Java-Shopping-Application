package cop4331.client;
import java.io.*;
import java.util.LinkedHashMap;

/**
 * @author Hunter B.
 */
public class Inventory implements Serializable
{
    LinkedHashMap<Integer, Product> productList = new LinkedHashMap<>();
    private Inventory()
    {

    }

    public int size()
    {
        return productList.size();
    }
    public void load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventory.dat"));
        instance = (Inventory) in.readObject();
        in.close();
    }

    public void save() throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
        out.writeObject(instance);
        out.close();
    }

    public void removeProduct(int id)
    {
        productList.remove(id);
    }

    public void addProduct(int id, String name, int quantity, double cost, double price)
    {
        Product newProduct = new Product(id, name, quantity, cost, price);
        productList.put(newProduct.getId(), newProduct);
    }

    public void editProduct(int id, String name, int quantity, double cost, double price)
    {
        Product editedProduct = new Product(id, name, quantity, cost, price);
        productList.replace(id, editedProduct);
    }

    public static Inventory getInstance()
    {
        return instance;
    }

    private static Inventory instance = new Inventory();
}
