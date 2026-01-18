package coreprogramming.methods.level2;
import java.util.Scanner;

/*
 * FactorsOperations
 * -----------------
 * This program:
 * 1. Takes a number from the user.
 * 2. Finds all its factors and stores them in an array.
 * 3. Displays the factors.
 * 4. Calculates and displays:
 *    - Sum of factors
 *    - Product of factors
 *    - Sum of squares of factors
 */
public class FactorsOperations {

    // Method to find and return all factors of a number in an array
    public static int[] findFactors(int number) {

        int count = 0;

        // First loop to count number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array with size equal to number of factors
        int[] factors = new int[count];

        int index = 0;

        // Second loop to store factors in array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Method to find sum of factors
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }

    // Method to find product of factors
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }

    // Method to find sum of squares of factors
    public static double findSumOfSquares(int[] factors) {
        double sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += Math.pow(factors[i], 2);
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Get factors using method
        int[] factors = findFactors(number);

        // Display factors
        System.out.println("\nFactors of " + number + " are:");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }

        // Calculate results
        int sum = findSum(factors);
        long product = findProduct(factors);
        double sumOfSquares = findSumOfSquares(factors);

        // Display results
        System.out.println("\n\nSum of factors = " + sum);
        System.out.println("Product of factors = " + product);
        System.out.println("Sum of squares of factors = " + sumOfSquares);
    }
}
