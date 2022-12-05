package cop4331.client;

import java.io.Serializable;

/**
 * A product or "item" in the store
 * @author Hunter B.
 */
public class Product implements Serializable
{
    private final int id;
    private String name;
    private int quantity;
    private double cost;
    private double price;
    private int amountToBeSold;

    /**
     * Constructs a product
     * @param id the product's id
     * @param name the product's name
     * @param quantity how much of the product is currently in stock
     * @param cost how much the product costs the store (seller) to buy
     * @param price how much the product costs a customer (buyer) to buy
     * @precondition id >= 0, quantity >= 0, cost >= 0, price >= 0
     */
    public Product(int id, String name, int quantity, double cost, double price)
    {
        assert id >= 0 && quantity >= 0 && cost >= 0 && price >= 0 : "violated precondition id >= 0, quantity >= 0, cost >= 0, price >= 0";
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        amountToBeSold = 0;
    }


    /**
     * Getter method for a product's id
     * @return the product's id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Getter method for the product's name
     * @return the product's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter method for the product's quantity
     * @return the product's quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Setter method for the product's quantity
     * @param quantity the product's new quantity
     * @precondition quantity >= 0
     */
    public void setQuantity(int quantity)
    {
        assert quantity >= 0 : "violated precondition quantity >= 0";
        this.quantity = quantity;
    }

    /**
     * Getter method for the product's cost
     * @return the product's cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * Setter method for the product's cost
     * @param cost the product's new cost
     * @precondition cost >= 0
     */
    public void setCost(double cost)
    {
        assert cost >= 0 : "violated precondition cost >= 0";
        this.cost = cost;
    }


    /**
     * Getter method for the product's price
     * @return the product's price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Setter method for the product's price
     * @param price the product's new price
     * @precondition price >= 0
     */
    public void setPrice(double price)
    {
        assert price >= 0 : "violated precondition price >= 0 ";
        this.price = price;
    }

    /**
     * Getter method for the amount of the product that is going to be sold
     * @return the amount of product the that is going to be sold
     */
    public int getAmountToBeSold()
    {
        return amountToBeSold;
    }

    /**
     * Setter method for the amount of the product that is going to be sold
     * @param amountToBeSold the amount of the product that is going to be sold
     */
    public void setAmountToBeSold(int amountToBeSold)
    {
        this.amountToBeSold = amountToBeSold;
    }
}
