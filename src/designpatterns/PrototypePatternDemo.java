package designpatterns;

/*
 * This program demonstrates the Prototype Design Pattern.
 * The Employee class implements Cloneable and overrides clone()
 * to create a copy of an existing object.
 * Cloning avoids creating objects from scratch.
 */

class Employee implements Cloneable {

    private String name; // Employee name
    private int id; // Employee ID
    private String department; // Employee department

    public Employee(String name, int id, String department) { // Constructor
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { // Override clone method
        return super.clone(); // Perform shallow copy
    }

    public void display() { // Display employee details
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
    }
}

public class PrototypePatternDemo {

    public static void main(String[] args) {

        try {
            Employee original = new Employee("Kushal", 101, "IT"); // Create original object

            Employee cloned = (Employee) original.clone(); // Clone the object

            System.out.println("Original Employee:");
            original.display();

            System.out.println("\nCloned Employee:");
            cloned.display();

            System.out.println("\nAre objects different in memory? " + (original != cloned)); // Verify different references

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}