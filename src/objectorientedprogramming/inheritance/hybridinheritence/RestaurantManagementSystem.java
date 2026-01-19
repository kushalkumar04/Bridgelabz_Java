package objectorientedprogramming.inheritance.hybridinheritence;
/*
 * Restaurant Management System
 *
 * Demonstrates hybrid inheritance.
 * Person is the superclass.
 * Worker is an interface requiring performDuties() method.
 * Chef and Waiter extend Person and implement Worker.
 *
 * Each subclass provides its own implementation of performDuties().
 */

// Superclass
class Person {

    // Common attributes for all persons in restaurant
    String name;
    int id;

    // Constructor
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display basic person info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Worker interface with performDuties() method
interface Worker {
    void performDuties();
}

// Chef class inherits Person and implements Worker
class Chef extends Person implements Worker {

    String specialtyDish;

    Chef(String name, int id, String specialtyDish) {
        super(name, id);
        this.specialtyDish = specialtyDish;
    }

    // Overridden method from Worker interface
    @Override
    public void performDuties() {
        System.out.println(name + " is cooking the specialty dish: " + specialtyDish);
    }
}

// Waiter class inherits Person and implements Worker
class Waiter extends Person implements Worker {

    int tableNumber;

    Waiter(String name, int id, int tableNumber) {
        super(name, id);
        this.tableNumber = tableNumber;
    }

    // Overridden method from Worker interface
    @Override
    public void performDuties() {
        System.out.println(name + " is serving table number: " + tableNumber);
    }
}

public class RestaurantManagementSystem {

    public static void main(String[] args) {

        // Creating Chef and Waiter objects
        Chef chef = new Chef("Gordon", 101, "Beef Wellington");
        Waiter waiter = new Waiter("Alice", 201, 5);

        // Display info and perform duties
        chef.displayInfo();
        chef.performDuties();
        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}