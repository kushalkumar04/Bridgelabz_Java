package coreprogramming.methods.level2;

import java.util.Scanner;

/*
 * YoungestAndTallest
 * ------------------
 * This program takes the age and height of three friends (Amar, Akbar, Anthony)
 * and finds:
 * 1. The youngest among them
 * 2. The tallest among them
 * using separate methods.
 */
public class YoungestAndTallest {

    // Method to find the youngest friend
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    // Method to find the tallest friend
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};

        int[] ages = new int[3];
        double[] heights = new double[3];

        // Taking input for each friend
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details of " + names[i]);
            System.out.print("Age: ");
            ages[i] = input.nextInt();

            System.out.print("Height: ");
            heights[i] = input.nextDouble();
            System.out.println();
        }

        // Find youngest and tallest using methods
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        // Display results
        System.out.println("Youngest Friend: " + names[youngestIndex] +
                " (Age = " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] +
                " (Height = " + heights[tallestIndex] + ")");
    }
}
