package coreprogramming.methods.level1;

import java.util.Scanner;

/*
 * SumOfNaturalNumbers
 * -------------------
 * This program calculates the sum of first n natural numbers
 * using a loop inside a method.
 */
public class SumOfNaturalNumbers {

    // Method to calculate sum of n natural numbers using loop
    public static int calculateSum(int n) {

        int sum = 0;

        // Loop from 1 to n
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for n
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        // Calling the method
        int result = calculateSum(n);

        // Displaying the result
        System.out.println("Sum of first " + n + " natural numbers = " + result);
    }
}

