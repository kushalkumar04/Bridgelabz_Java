package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class finds the smallest number among three integers entered by the user.
 * It compares the numbers using conditional statements and prints the smallest one.
 */
public class SmallestNumber {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read three integer values from the user
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        // Check if the first number is the smallest
        if (number1 < number2 && number1 < number3) {
            System.out.println(number1 + " is smallest");
        }
        // Check if the second number is the smallest
        else if (number2 < number1 && number2 < number3) {
            System.out.println(number2 + " is smallest");
        }
        // Otherwise, the third number is the smallest
        else {
            System.out.println(number3 + " is smallest");
        }
    }
}