package objectorientedprogramming.classandobject.level2;

/*
 * This class represents an item in a shopping cart.
 * It stores the item name, price, and quantity.
 * It provides methods to add items, remove items,
 * and calculate the total cost of the items in the cart.
 */
class CartItem {

    // Instance variables to store cart item details
    String itemName;
    double price;
    int quantity;

    // Method to add an item to the cart
    public void addItem(String name, double itemPrice, int qty) {
        itemName = name;
        price = itemPrice;
        quantity = qty;
        System.out.println("Item added to cart: " + itemName);
    }

    // Method to remove an item from the cart
    public void removeItem() {
        System.out.println("Item removed from cart: " + itemName);
        itemName = null;
        price = 0;
        quantity = 0;
    }

    // Method to calculate total cost
    public double getTotalCost() {
        return price * quantity;
    }

    // Method to display total cost
    public void displayTotalCost() {
        System.out.println("Total Cost: INR " + getTotalCost());
    }
}

/*
 * This class contains the main method to simulate
 * basic shopping cart operations.
 */
public class ShoppingCart {

    public static void main(String[] args) {

        // Create an object of CartItem
        CartItem cart = new CartItem();

        // Add an item to the cart
        cart.addItem("Headphones", 1500.0, 2);

        // Display total cost
        cart.displayTotalCost();

        // Remove the item from the cart
        cart.removeItem();

        // Display total cost after removal
        cart.displayTotalCost();
    }
}
