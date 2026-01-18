package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * MultiplicationTableFrom6To9
 * --------------------------
 * This program takes a number from the user and prints its
 * multiplication table from 6 to 9.
 * The results are stored in an integer array and then displayed.
 */
public class MutliplicationTableFromSixToNine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Array to store multiplication results for 6, 7, 8, and 9
        int[] multiplicationResult = new int[4];

        // Loop from 6 to 9 and store results in the array
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        System.out.println("\nMultiplication Table of " + number + " from 6 to 9:");

        // Display the result in the required format
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }
    }
}
