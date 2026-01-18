package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * MultiplicationTable
 * -------------------
 * This program takes an integer input from the user and generates
 * its multiplication table from 1 to 10.
 * The results are stored in an integer array and then displayed.
 */
public class MultiplicationTable {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Array to store multiplication results from 1 to 10
        int[] table = new int[10];

        // Loop to calculate and store multiplication values
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;  // Store result in array
        }

        System.out.println("\nMultiplication Table of " + number + ":");

        // Loop to display the multiplication table in required format
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }
}
