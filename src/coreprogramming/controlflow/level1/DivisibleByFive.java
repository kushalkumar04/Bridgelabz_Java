package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class checks whether a given integer is divisible by 5.
 * It takes input from the user and prints the result accordingly.
 */
public class DivisibleByFive {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Read an integer value from the user
        int number = input.nextInt();

        // Check if the number is divisible by 5
        if (number % 5 == 0) {
            // If remainder is 0, the number is divisible by 5
            System.out.println("It is divisible");
        }
        else {
            // If remainder is not 0, the number is not divisible by 5
            System.out.println("Not divisible");
        }
    }
}