package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class reads three integers from the user and checks
 * which one is the largest among them using logical conditions.
 * It prints boolean results indicating whether each number
 * is the largest compared to the other two.
 */
public class LargestNumber {

    public static void main(String[] args) {

        // Create Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Read three integer values from the user
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        // Check and print whether each number is the largest
        System.out.println(
                "Is the first number the largest? " + (number1 > number2 && number1 > number3) +
                        "\nIs the second number the largest? " + (number2 > number1 && number2 > number3) +
                        "\nIs the third number the largest? " + (number3 > number1 && number3 > number2)
        );

        // Close the Scanner to release resources
        input.close();
    }
}