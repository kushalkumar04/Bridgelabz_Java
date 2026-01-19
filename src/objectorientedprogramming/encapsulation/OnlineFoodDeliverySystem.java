package objectorientedprogramming.encapsulation;
/*
 * Online Food Delivery System
 *
 * Features:
 * - Abstract class FoodItem
 * - Interface Discountable
 * - Subclasses VegItem and NonVegItem
 * - Encapsulation
 * - Polymorphism via FoodItem list
 */

import java.util.ArrayList;
import java.util.List;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercent;

    public VegItem(String name, double price, int quantity, double discountPercent) {
        super(name, price, quantity);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * (discountPercent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on VegItem: " + discountPercent + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge;
    private double discountPercent;

    public NonVegItem(String name, double price, int quantity, double extraCharge, double discountPercent) {
        super(name, price, quantity);
        this.extraCharge = extraCharge;
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraCharge) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * (discountPercent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on NonVegItem: " + discountPercent + "%";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem veg = new VegItem("Paneer Curry", 150, 2, 10);
        NonVegItem nonVeg = new NonVegItem("Chicken Biryani", 200, 1, 50, 5);

        order.add(veg);
        order.add(nonVeg);

        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                System.out.println(((Discountable)item).getDiscountDetails());
                System.out.println("Final Price: " + (item.calculateTotalPrice() - ((Discountable)item).applyDiscount()));
            }
            System.out.println("---------------------------------");
        }
    }
}