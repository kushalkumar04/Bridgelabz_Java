package coreprogramming.controlflow.level3;

import java.util.Scanner;

/*
 * HarshadNumberCheck
 * ------------------
 * This program checks whether a given number is a Harshad Number or not.
 * A Harshad Number is an integer that is divisible by the sum of its digits.
 * Example: 21 -> 2 + 1 = 3, and 21 is divisible by 3, so it is a Harshad Number.
 */
public class HarshadNumberCheck {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking integer input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int originalNumber = number; // Store original number for later use
        int sum = 0;                 // Variable to store sum of digits

        // Loop to extract each digit and add it to sum
        while (number != 0) {
            int digit = number % 10;   // Get last digit
            sum = sum + digit;         // Add digit to sum
            number = number / 10;      // Remove last digit
        }

        // Check if original number is divisible by sum of its digits
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number");
        } else {
            System.out.println(originalNumber + " is NOT a Harshad Number");
        }
    }
}
