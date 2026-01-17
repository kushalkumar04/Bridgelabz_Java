package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class checks whether a person is eligible to vote based on their age.
 * It takes the age as input from the user and prints whether the person
 * can vote or not according to the legal voting age (18 years).
 */
public class VotingEligibility {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read the age of the person
        int age = input.nextInt();

        // Check if the age is 18 or above
        if (age >= 18) {
            // If age is 18 or more, the person is eligible to vote
            System.out.println("The person's age is " + age + " and can vote.");
        }
        else {
            // If age is less than 18, the person is not eligible to vote
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        // Close the Scanner to release system resources
        input.close();
    }
}