package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * NumberAnalysis
 * --------------
 * This program:
 * 1. Takes 5 integer inputs from the user and stores them in an array.
 * 2. Checks each number whether it is Positive, Negative, or Zero.
 * 3. If the number is Positive, it further checks whether it is Even or Odd.
 * 4. Finally, it compares the first and last elements of the array and
 *    prints whether they are equal, greater, or less.
 */
public class NumberAnalysis {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declare an array of size 5
        int[] numbers = new int[5];

        // Taking input from the user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Number Check Result ---");

        // Loop through the array and check each number
        for (int i = 0; i < numbers.length; i++) {

            int num = numbers[i];

            if (num > 0) {
                // Positive number
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            }
            else if (num < 0) {
                // Negative number
                System.out.println(num + " is Negative");
            }
            else {
                // Zero
                System.out.println(num + " is Zero");
            }
        }

        System.out.println("\n--- Comparison of First and Last Elements ---");

        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("First and Last elements are Equal");
        }
        else if (first > last) {
            System.out.println("First element is Greater than Last element");
        }
        else {
            System.out.println("First element is Less than Last element");
        }
    }
}

