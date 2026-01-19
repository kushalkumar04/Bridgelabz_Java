package objectorientedprogramming.encapsulation;
/*
 * E-Commerce Platform
 *
 * Features:
 * - Abstract Product class
 * - Interface Taxable
 * - Subclasses Electronics, Clothing, Groceries
 * - Encapsulation
 * - Polymorphism demonstrated via Product list
 */

import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }

    public abstract double calculateDiscount();
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    private double taxRate;

    public Electronics(int id, String name, double price, double taxRate) {
        super(id, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.10; } // 10% discount

    @Override
    public double calculateTax() { return getPrice() * taxRate; }

    @Override
    public String getTaxDetails() { return "Electronics Tax: " + calculateTax(); }
}

// Clothing subclass
class Clothing extends Product implements Taxable {
    private double taxRate;

    public Clothing(int id, String name, double price, double taxRate) {
        super(id, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.15; } // 15% discount

    @Override
    public double calculateTax() { return getPrice() * taxRate; }

    @Override
    public String getTaxDetails() { return "Clothing Tax: " + calculateTax(); }
}

// Groceries subclass
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.05; } // 5% discount
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Electronics laptop = new Electronics(1, "Laptop", 80000, 0.18);
        Clothing tshirt = new Clothing(2, "T-Shirt", 1200, 0.05);
        Groceries rice = new Groceries(3, "Rice", 500);

        products.add(laptop);
        products.add(tshirt);
        products.add(rice);

        for (Product p : products) {
            p.displayProduct();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Discount: " + discount);
            if (p instanceof Taxable) System.out.println(((Taxable)p).getTaxDetails());
            System.out.println("Final Price: " + finalPrice);
            System.out.println("---------------------------------");
        }
    }
}