package coreprogramming.methods.level3;

import java.util.Scanner;

/*
 * NumberChecker
 * -------------
 * Utility class that performs various operations on a number using its digits.
 */
public class NumberChecker {

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

    // Method to check Duck Number (has at least one non-zero digit)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check Armstrong Number
    public static boolean isArmstrong(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digits
    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);
    }

    // Method to find smallest and second smallest digits
    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }

        System.out.println("Smallest Digit = " + smallest);
        System.out.println("Second Smallest Digit = " + secondSmallest);
    }

    // Main method to test all functions
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Digit Count = " + countDigits(number));

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(number, digits));

        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
    }
}
