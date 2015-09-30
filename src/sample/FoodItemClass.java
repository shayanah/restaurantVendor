package sample;

import java.io.Serializable;

/**
 * Created by shawn on 9/29/2015.
 */
public class FoodItemClass implements Serializable
{
    private String name;
    private double price;
    private int quantity;
    private String description;
    private int size;
    private String SpecialOrder;



    public FoodItemClass(String name, double price, int quantity, String description, int size, String specialOrder) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.size = size;
        SpecialOrder = specialOrder;
    }

    @Override
    public String toString() {
        return "FoodItemClass{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", SpecialOrder='" + SpecialOrder + '\'' +
                '}' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItemClass)) return false;

        FoodItemClass that = (FoodItemClass) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (quantity != that.quantity) return false;
        if (size != that.size) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return !(SpecialOrder != null ? !SpecialOrder.equals(that.SpecialOrder) : that.SpecialOrder != null);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSpecialOrder() {
        return SpecialOrder;
    }

    public void setSpecialOrder(String specialOrder) {
        SpecialOrder = specialOrder;
    }
}
