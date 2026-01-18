package coreprogramming.controlflow.level3;

import java.util.Scanner;

/*
 * DigitCount
 * -----------
 * This program counts the number of digits in a given integer.
 * It repeatedly removes the last digit of the number using division
 * and increments a counter until the number becomes 0.
 */
public class DigitCount {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking integer input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Variable to store the count of digits
        int count = 0;

        // Loop until the number becomes 0
        while (number != 0) {

            // Remove the last digit of the number
            number = number / 10;

            // Increase the digit count
            count++;
        }

        // Display the total number of digits
        System.out.println("Number of digits = " + count);
    }
}
