package coreprogramming.controlflow.level3;

import java.util.Scanner;

/*
 * PrimeNumberCheck
 * ----------------
 * This program checks whether a given number is a Prime Number.
 * A Prime Number is a number greater than 1 that is divisible only by 1 and itself.
 * We use a boolean variable 'isPrime' to store the result.
 */
public class PrimeNumberCheck {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Boolean variable to store whether the number is prime or not
        boolean isPrime = true;

        // Prime number check is valid only for numbers greater than 1
        if (number <= 1) {
            isPrime = false;
        }
        else {
            // Loop from 2 to number - 1
            for (int i = 2; i < number; i++) {

                // If number is divisible by any i, remainder will be 0
                if (number % i == 0) {
                    isPrime = false; // Not a prime number
                    break;          // Exit the loop as divisor is found
                }
            }
        }

        // Display the result
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is NOT a Prime Number");
        }
    }
}
