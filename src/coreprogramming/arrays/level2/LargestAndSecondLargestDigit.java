package coreprogramming.arrays.level2;

import java.util.Scanner;

/*
 * LargestAndSecondLargestDigit
 * ----------------------------
 * This program stores the digits of a given number into an array
 * and finds the largest and second largest digit from that array.
 */
public class LargestAndSecondLargestDigit {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int maxDigit = 10;                 // Maximum size of the digit array
        int[] digits = new int[maxDigit]; // Array to store digits
        int index = 0;                    // Index for array

        // Loop to extract digits and store in array
        while (number != 0) {

            // Store last digit in array
            digits[index] = number % 10;

            // Remove last digit from number
            number = number / 10;

            // Move to next index
            index++;

            // If array is full, stop storing more digits
            if (index == maxDigit) {
                break;
            }
        }

        // Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Loop through the stored digits to find largest and second largest
        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            }
            else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display the results
        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);
    }
}

