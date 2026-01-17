package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class calculates the sum of the first N natural numbers.
 * It takes an integer input from the user, checks if it is a valid
 * natural number, and then uses the mathematical formula
 * sum = n * (n + 1) / 2 to compute the result.
 */
public class SumOfNaturalNumbers {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read the number up to which the sum of natural numbers is required
        int number = input.nextInt();

        // Check if the entered number is a natural number (0 or positive)
        if (number >= 0) {

            // Calculate the sum using the formula for sum of first N natural numbers
            int sum = number * (number + 1) / 2;

            // Display the calculated sum
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        }
        else {
            // Display message if the entered number is not a natural number
            System.out.println("The number " + number + " is not a natural number");
        }

        // Close the Scanner to free resources
        input.close();
    }
}