package coreprogramming.methods.level3;

import java.util.Scanner;

/*
 * NumberChecker
 * -------------
 * Utility class to perform various digit-based operations on a number.
 */
public class NumberCheckerTwo {

    // Method to find count of digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits in an array
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = 0;

        while (number != 0) {
            digits[index++] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reverse = new int[digits.length];
        int index = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            reverse[index++] = digits[i];
        }
        return reverse;
    }

    // Method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    // Method to check Palindrome using digits
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    // Method to check Duck Number (has at least one non-zero digit)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // Main method to test all methods
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Count of Digits = " + countDigits(number));

        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        int[] reversed = reverseArray(digits);

        System.out.print("Reversed Digits Array: ");
        for (int d : reversed) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Are Original and Reversed Arrays Equal: " +
                areArraysEqual(digits, reversed));

        System.out.println("Is Palindrome Number: " + isPalindrome(digits));

        System.out.println("Is Duck Number: " + isDuckNumber(digits));
    }
}
