package cop4331.client;

import java.io.Serializable;

/**
 * @author Hunter B.
 */
public class Product implements Serializable
{
    private int id;
    private String name;
    private int quantity;
    private double cost;
    private double price;

    public Product(int id, String name, int quantity, double cost, double price)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
