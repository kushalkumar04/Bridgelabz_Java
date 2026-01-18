package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * MeanHeightOfPlayers
 * -------------------
 * This program calculates the mean (average) height of 11 football players.
 * Mean = Sum of all heights / Number of players
 */
public class MeanHeightOfPlayers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array to store heights of 11 players
        double[] heights = new double[11];

        // Variable to store sum of all heights
        double sum = 0;

        // Taking height input for all 11 players
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
            sum = sum + heights[i]; // Adding each height to sum
        }

        // Calculate mean height
        double mean = sum / heights.length;

        // Display the mean height
        System.out.println("\nMean height of the football team = " + mean);
    }
}
