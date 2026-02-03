package exceptions;

/*
 * This program demonstrates a user-defined (custom) exception.
 * It validates a user's age and throws InvalidAgeException
 * if the age is below 18.
 */
import java.util.Scanner;

// Custom Exception class
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = input.nextInt();

            validateAge(age);
            System.out.println("Access granted!");
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            input.close();
        }
    }
}

