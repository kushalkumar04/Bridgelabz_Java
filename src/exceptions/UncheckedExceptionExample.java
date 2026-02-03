package exceptions;

/*
 * This program demonstrates handling of unchecked exceptions.
 * It divides two numbers entered by the user and handles:
 * 1. ArithmeticException – when division by zero occurs.
 * 2. InputMismatchException – when non-numeric input is entered.
 */
import java.util.*;

public class UncheckedExceptionExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = input.nextInt();

            System.out.print("Enter second number: ");
            int b = input.nextInt();

            // Perform division
            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values.");
        }
        finally {
            input.close();
        }
    }
}
