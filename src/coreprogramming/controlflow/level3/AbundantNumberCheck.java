package coreprogramming.controlflow.level3;
import java.util.Scanner;

/*
 * AbundantNumberCheck
 * -------------------
 * This program checks whether a given number is an Abundant Number.
 * An Abundant Number is a number whose sum of all proper divisors
 * (excluding the number itself) is greater than the number.
 * Example: 12 -> Divisors: 1, 2, 3, 4, 6 -> Sum = 16 (> 12)
 */
public class AbundantNumberCheck {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking integer input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int sum = 0; // Variable to store sum of divisors

        // Loop from 1 to number - 1 to find all proper divisors
        for (int i = 1; i < number; i++) {

            // Check if i is a divisor of number
            if (number % i == 0) {
                sum = sum + i; // Add divisor to sum
            }
        }

        // Check if the sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is NOT an Abundant Number");
        }
    }
}
