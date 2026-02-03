package exceptions;

/*
 * This program demonstrates rethrowing exceptions in Java.
 * An ArithmeticException is thrown during division, rethrown
 * with additional context, and handled in the main method.
 */
public class RethrowingExceptionExample {

    // Method that performs division
    public static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }

    // Method that calls performDivision and rethrows exception with context
    public static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            // Rethrow with additional context
            throw new ArithmeticException("Error during calculation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        try {
            int result = calculate(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Calculation failed: " + e.getMessage());
        }
    }
}
