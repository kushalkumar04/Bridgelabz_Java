package exceptions;

/*
 * This program demonstrates the execution of the finally block.
 * It performs integer division and handles ArithmeticException.
 * The finally block always executes and prints a completion message.
 */
import java.util.*;

public class FinallyBlockExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = input.nextInt();

            System.out.print("Enter second number: ");
            int b = input.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
        finally {
            System.out.println("Operation completed");
            input.close();
        }
    }
}
