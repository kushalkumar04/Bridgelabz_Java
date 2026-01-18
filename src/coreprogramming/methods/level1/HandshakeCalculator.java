package coreprogramming.methods.level1;

import java.util.Scanner;

/*
 * HandshakeCalculator
 * -------------------
 * This program calculates the maximum number of handshakes
 * possible among N students using the combination formula:
 * Handshakes = (n * (n - 1)) / 2
 */
public class HandshakeCalculator {

    // Method to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Calling the method
        int result = calculateHandshakes(n);

        // Displaying the result
        System.out.println("Maximum number of handshakes among " + n + " students = " + result);
    }
}
