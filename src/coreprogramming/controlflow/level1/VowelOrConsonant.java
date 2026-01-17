package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class checks whether a given character is a vowel or a consonant.
 * It takes a single character as input from the user and compares it
 * with all vowel characters (both uppercase and lowercase).
 */
public class VowelOrConsonant {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read a single character from the user
        char ch = input.next().charAt(0);

        // Check if the character is a vowel (either lowercase or uppercase)
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {

            // If the character is a vowel, print the result
            System.out.println(ch + " is a Vowel");
        }
        else {
            // If the character is not a vowel, it is a consonant
            System.out.println(ch + " is a Consonant");
        }

        // Close the Scanner to free resources
        input.close();
    }
}