package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * VotingEligibilityCheck
 * ----------------------
 * This program takes the age of 10 students as input using an array.
 * For each student, it checks:
 * 1. If age is negative -> Invalid age
 * 2. If age is 18 or above -> Can vote
 * 3. If age is below 18 -> Cannot vote
 */
public class VotingEligibilityCheck {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create an array to store ages of 10 students
        int[] ages = new int[10];

        // Taking input for all 10 students
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = input.nextInt();
        }

        System.out.println("\n--- Voting Eligibility Result ---");

        // Loop through the array and check voting eligibility
        for (int i = 0; i < ages.length; i++) {

            int age = ages[i];

            if (age < 0) {
                System.out.println("Invalid age: " + age);
            }
            else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            }
            else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
    }
}
