package coreprogramming.methods.level1;

import java.util.Scanner;

/*
 * SimpleInterestCalculator
 * ------------------------
 * This program takes Principal, Rate, and Time from the user,
 * calculates Simple Interest using a method, and displays the result.
 */
public class SimpleInterestCalculator {

    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking inputs from the user
        System.out.print("Enter Principal: ");
        double principal = input.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter Time: ");
        double time = input.nextDouble();

        // Calling the method to calculate Simple Interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        // Displaying the result
        System.out.println("The Simple Interest is " + simpleInterest +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);
    }
}
