package objectorientedprogramming.classandobject.level1;

/*******************************************************
 * This class represents an Item in an inventory system.
 * It stores the item code, item name, and price.
 * It also provides methods to display item details
 * and calculate the total cost for a given quantity.
 *******************************************************/
class Item {

    // Instance variables to store item details
    int itemCode;
    String itemName;
    double price;

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : INR " + price);
    }

    // Method to calculate total cost based on quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

/*
 * This class contains the main method to create an Item object,
 * display its details, and calculate the total cost for
 * a given quantity.
 */
public class InventoryTracker {

    public static void main(String[] args) {

        // Create an object of Item class
        Item item = new Item();

        // Assign values to the item attributes
        item.itemCode = 1001;
        item.itemName = "Notebook";
        item.price = 45.50;

        // Display item details
        item.displayDetails();

        // Quantity of items to purchase
        int quantity = 5;

        // Calculate and display total cost
        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: INR " + totalCost);
    }
}
