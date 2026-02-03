package exceptions;

/*
 * This program demonstrates the use of multiple catch blocks.
 * It retrieves a value from an array based on a given index
 * and handles possible runtime exceptions.
 */
import java.util.*;

public class MultipleCatchExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            // Example array (set to null to test NullPointerException)
            int[] arr = {10, 20, 30, 40, 50};

            System.out.print("Enter index: ");
            int index = input.nextInt();

            // Access array element
            System.out.println("Value at index " + index + ": " + arr[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        finally {
            input.close();
        }
    }
}

