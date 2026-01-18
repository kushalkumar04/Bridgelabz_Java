package coreprogramming.arrays.level2;

import java.util.Scanner;

/*
 * ReverseNumberUsingArray
 * -----------------------
 * This program takes a number from the user, stores its digits in an array,
 * then reverses the number by copying the digits into another array
 * in reverse order and finally displays the reversed number.
 */
public class ReverseNumberUsingArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int temp = number;
        int count = 0;

        // Step 1: Find number of digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Step 2: Create array to store digits
        int[] digits = new int[count];
        temp = number;

        // Step 3: Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // Step 4: Create another array to store reversed digits
        int[] reverse = new int[count];
        int index = 0;

        for (int i = count - 1; i >= 0; i--) {
            reverse[index] = digits[i];
            index++;
        }

        // Step 5: Display reversed number
        System.out.print("Reversed Number = ");
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i]);
        }
    }
}
