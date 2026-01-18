package coreprogramming.methods.level3;

import java.util.Scanner;

/*
 * LineAndDistance
 * ---------------
 * This program calculates:
 * 1. The Euclidean distance between two points
 * 2. The equation of the line in the form y = m*x + b
 * where m is the slope and b is the y-intercept.
 */
public class LineAndDistance {

    // Method to find Euclidean distance
    public static double findDistance(double x1, double y1, double x2, double y2) {
        double dx = Math.pow((x2 - x1), 2);
        double dy = Math.pow((y2 - y1), 2);
        return Math.sqrt(dx + dy);
    }

    // Method to find slope and y-intercept
    // Returns array: result[0] = slope (m), result[1] = y-intercept (b)
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {

        double m = (y2 - y1) / (x2 - x1);   // slope
        double b = y1 - (m * x1);          // y-intercept

        return new double[]{m, b};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        // Calculate distance
        double distance = findDistance(x1, y1, x2, y2);

        // Calculate line equation
        double[] line = findLineEquation(x1, y1, x2, y2);
        double slope = line[0];
        double intercept = line[1];

        // Display results
        System.out.println("\nEuclidean Distance = " + distance);
        System.out.println("Equation of Line: y = " + slope + "x + " + intercept);
    }
}
