package coreprogramming.methods.level1;

import java.util.Scanner;

/*
 * TriangularParkRun
 * -----------------
 * This program calculates how many rounds an athlete must run
 * in a triangular park to complete a 5 km (5000 meters) run.
 * Rounds = Total Distance / Perimeter of the triangle
 */
public class TriangularParkRun {

    // Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;   // Perimeter of triangle
        double totalDistance = 5000;               // 5 km in meters
        return totalDistance / perimeter;          // Number of rounds
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for the three sides of the triangular park
        System.out.print("Enter side 1 (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = input.nextDouble();

        // Calling the method to calculate rounds
        double rounds = calculateRounds(side1, side2, side3);

        // Displaying the result
        System.out.println("The athlete must complete " + rounds + " rounds to run 5 km.");
    }
}
