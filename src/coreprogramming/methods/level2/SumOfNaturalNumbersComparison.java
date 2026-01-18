package coreprogramming.methods.level2;
import java.util.Scanner;

/*
 * SumOfNaturalNumbersComparison
 * -----------------------------
 * This program finds the sum of n natural numbers using:
 * 1. A recursive method
 * 2. The mathematical formula n*(n+1)/2
 * It then compares both results to verify correctness.
 */
public class SumOfNaturalNumbersComparison {

    // Recursive method to find sum of n natural numbers
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    // Method to find sum using formula
    public static int sumUsingFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
            return;
        }

        // Calculate sum using recursion
        int recursiveSum = sumUsingRecursion(n);

        // Calculate sum using formula
        int formulaSum = sumUsingFormula(n);

        // Display both results
        System.out.println("Sum using Recursion = " + recursiveSum);
        System.out.println("Sum using Formula   = " + formulaSum);

        // Compare results
        if (recursiveSum == formulaSum) {
            System.out.println("Both results are equal. Computation is correct.");
        } else {
            System.out.println("Results are not equal. There is an error in computation.");
        }
    }
}
