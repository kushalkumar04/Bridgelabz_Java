package coreprogramming.arrays.level2;

import java.util.Scanner;

/*
 * YoungestAndTallestFriend
 * -----------------------
 * This program takes age and height of three friends (Amar, Akbar, Anthony)
 * and finds:
 * 1. The youngest among them
 * 2. The tallest among them
 */
public class YoungestAndTallestFriend {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store ages and heights
        int[] age = new int[3];
        double[] height = new double[3];

        // Taking input for each friend
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details of " + names[i]);
            System.out.print("Age: ");
            age[i] = input.nextInt();

            System.out.print("Height: ");
            height[i] = input.nextDouble();
            System.out.println();
        }

        // Assume first person is youngest and tallest initially
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop to find youngest and tallest
        for (int i = 1; i < 3; i++) {

            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }

            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display results
        System.out.println("Youngest Friend: " + names[youngestIndex] +
                " (Age = " + age[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] +
                " (Height = " + height[tallestIndex] + ")");
    }
}

