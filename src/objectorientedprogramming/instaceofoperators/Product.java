
package objectorientedprogramming.instaceofoperators;
/*
 * Product class demonstrates static, this, final, and instanceof
 */

public class Product {

    // Static variable
    static double discount = 10.0;

    // Final variable
    final int productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Constructor using this
    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method using instanceof
    void processProduct(Object obj) {
        if (obj instanceof Product) {
            System.out.println("Product: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000, 1, 1001);
        Product.updateDiscount(15);
        p1.processProduct(p1);
    }
}
