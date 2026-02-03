package exceptions;

/*
 * This program demonstrates the difference between throw and throws.
 * The calculateInterest() method uses 'throw' to raise an exception
 * and 'throws' to propagate it to the calling method.
 */
public class ThrowVsThrowsExample {

    // Method that propagates exception using throws
    public static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {

        if (amount < 0 || rate < 0) {
            // throw keyword is used to explicitly throw an exception
            throw new IllegalArgumentException("Invalid input");
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {

        try {
            double interest = calculateInterest(10000, 5, 2);
            System.out.println("Calculated Interest: " + interest);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
