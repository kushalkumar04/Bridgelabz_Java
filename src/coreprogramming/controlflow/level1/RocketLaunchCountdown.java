package coreprogramming.controlflow.level1;

import java.util.Scanner;

/*
 * This class simulates a rocket launch countdown.
 * It takes a starting number from the user and counts down
 * to 1 using a while loop, printing each value.
 */
public class RocketLaunchCountdown {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Read the starting value for the countdown
        int counter = input.nextInt();

        // Loop until the counter reaches 1
        while (counter >= 1) {

            // Print the current countdown number
            System.out.println(counter);

            // Decrease the counter by 1 in each iteration
            counter--;
        }
    }
}