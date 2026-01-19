package objectorientedprogramming.classandobject.level1;

/*
 * This class represents a Circle with a given radius.
 * It contains methods to calculate and display the
 * area and circumference of the circle.
 */
class Circle {

    // Attribute to store the radius of the circle
    double radius;

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display the area and circumference
    public void displayDetails() {
        System.out.println("Radius of the circle: " + radius);
        System.out.println("Area of the circle: " + calculateArea());
        System.out.println("Circumference of the circle: " + calculateCircumference());
    }
}

/*
 * This class contains the main method to create a Circle object
 * and invoke its methods.
 */
public class CircleDetails {

    public static void main(String[] args) {

        // Create an object of Circle class
        Circle circle = new Circle();

        // Assign value to the radius
        circle.radius = 7.0;

        // Display the area and circumference of the circle
        circle.displayDetails();
    }
}
