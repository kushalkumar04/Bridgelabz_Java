package coreprogramming.controlflow.level2;

import java.util.Scanner;

/*
 * This class implements the FizzBuzz program.
 * It takes a positive integer from the user and prints numbers from 1 to that number.
 * For multiples of 3, it prints "Fizz", for multiples of 5 it prints "Buzz",
 * and for multiples of both 3 and 5 it prints "FizzBuzz".
 */
public class FizzBuzz {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read an integer value from the user
        int number = input.nextInt();

        // Check if the entered number is positive
        if (number > 0) {

            // Loop from 1 to the given number
            for (int i = 1; i <= number; i++) {

                // Check if the number is divisible by both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check if the number is divisible only by 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check if the number is divisible only by 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                // If the number is not divisible by 3 or 5, print the number itself
                else {
                    System.out.println(i);
                }
            }
        }
        else {
            // Display message if the user enters a non-positive number
            System.out.println("Enter a positive number");
        }
    }
}