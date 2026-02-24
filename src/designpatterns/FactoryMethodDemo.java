package designpatterns;

/*
 * This program demonstrates the Factory Method Design Pattern.
 * The ShapeFactory class creates objects based on input type
 * without exposing the instantiation logic to the client.
 * It promotes loose coupling and centralized object creation.
 */

interface Shape {
    void draw(); // Abstract method to be implemented
}

class Circle implements Shape {

    @Override
    public void draw() { // Circle implementation
        System.out.println("Drawing Circle...");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() { // Rectangle implementation
        System.out.println("Drawing Rectangle...");
    }
}

class ShapeFactory {

    public static Shape getShape(String type) { // Factory method

        if (type == null) return null; // Handle null input

        if (type.equalsIgnoreCase("CIRCLE")) { // Create Circle object
            return new Circle();
        }
        else if (type.equalsIgnoreCase("RECTANGLE")) { // Create Rectangle object
            return new Rectangle();
        }

        return null; // Return null if type not matched
    }
}

public class FactoryMethodDemo {

    public static void main(String[] args) {

        Shape shape1 = ShapeFactory.getShape("CIRCLE"); // Get Circle from factory
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("RECTANGLE"); // Get Rectangle from factory
        shape2.draw();
    }
}