package coreprogramming.arrays.level2;

import java.util.Scanner;

/*
 * BMICalculationUsing2DArray
 * -------------------------
 * This program takes input for weight and height of multiple persons,
 * stores Weight, Height, and BMI in a 2D array, and stores the weight
 * status in a separate String array.
 * It then displays the details of each person.
 */
public class BMICalculationUsing2DArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        // 2D array to store Weight, Height, and BMI
        double[][] personData = new double[number][3];

        // Array to store weight status
        String[] weightStatus = new String[number];

        // Input loop
        for (int i = 0; i < number; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            // Taking Weight
            System.out.print("Enter Weight (kg): ");
            double weight = input.nextDouble();

            // Validate weight
            if (weight <= 0) {
                System.out.println("Invalid weight! Enter a positive value.");
                i--;
                continue;
            }

            // Taking Height
            System.out.print("Enter Height (meters): ");
            double height = input.nextDouble();

            // Validate height
            if (height <= 0) {
                System.out.println("Invalid height! Enter a positive value.");
                i--;
                continue;
            }

            // Store weight and height
            personData[i][0] = weight;
            personData[i][1] = height;

            // Calculate BMI = weight / (height * height)
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            // Determine weight status
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n----- BMI Report -----");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("BMI   : " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
