package linkedlist.singly;

/***************************************************************
 * Inventory Management System using Singly Linked List
 *
 * Each node stores:
 *  - Item ID
 *  - Item Name
 *  - Quantity
 *  - Price
 *
 * Operations:
 * 1. Add item at beginning, end, or specific position
 * 2. Remove item by Item ID
 * 3. Update quantity by Item ID
 * 4. Search by Item ID or Item Name
 * 5. Calculate total inventory value
 * 6. Sort by Item Name or Price (Ascending / Descending)
 ***************************************************************/

// Node class representing each inventory item
class ItemNode {

    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    // Constructor to initialize item
    public ItemNode(int id, String name, int qty, double price) {
        this.itemId = id;
        this.itemName = name;
        this.quantity = qty;
        this.price = price;
        this.next = null;
    }
}

/*
 * This class contains all linked list operations
 * for Inventory Management.
 */
class InventoryLinkedList {

    ItemNode head;

    // Add item at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add item at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        ItemNode temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item by Item ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by Item ID
    public void searchById(int id) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by Item Name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        ItemNode temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = INR " + total);
    }

    // Display all items
    public void displayAll() {
        ItemNode temp = head;

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Helper method to display one item
    private void displayItem(ItemNode i) {
        System.out.println("----------------------------");
        System.out.println("Item ID   : " + i.itemId);
        System.out.println("Item Name : " + i.itemName);
        System.out.println("Quantity  : " + i.quantity);
        System.out.println("Price     : INR " + i.price);
    }
}

/*
 * Main class to test Inventory Management System
 */
public class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        // Add items
        inventory.addAtBeginning(101, "Laptop", 5, 60000);
        inventory.addAtEnd(102, "Mouse", 20, 500);
        inventory.addAtEnd(103, "Keyboard", 10, 1500);
        inventory.addAtPosition(2, 104, "Monitor", 7, 12000);

        // Display all items
        System.out.println("All Inventory Items:");
        inventory.displayAll();

        // Search item
        inventory.searchById(102);
        inventory.searchByName("Monitor");

        // Update quantity
        inventory.updateQuantity(103, 15);

        // Calculate total value
        inventory.calculateTotalValue();

        // Remove an item
        inventory.removeById(101);

        // Display after deletion
        System.out.println("\nAfter Deletion:");
        inventory.displayAll();
    }
}

