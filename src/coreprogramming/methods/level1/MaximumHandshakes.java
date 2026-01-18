package coreprogramming.methods.level1;
import java.util.Scanner;

/*
 * MaximumHandshakes
 * -----------------
 * This program calculates the maximum number of handshakes
 * possible among N students using the formula:
 * Handshakes = (n * (n - 1)) / 2
 */
public class MaximumHandshakes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate maximum number of handshakes
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println("Maximum number of possible handshakes = " + handshakes);
    }
}
