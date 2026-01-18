package coreprogramming.arrays.level1;

import java.util.Scanner;

/*
 * MatrixToSingleDimensionArray
 * ----------------------------
 * This program creates a 2D array (matrix) based on user input for
 * number of rows and columns. It then copies all elements of the
 * 2D array into a 1D array.
 */
public class MatrixToSingleDimensionArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for number of rows and columns
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        // Creating 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Taking input for each element of the 2D array
        System.out.println("\nEnter elements of the matrix:");
        for (int i = 0; i < rows; i++) {             // Outer loop for rows
            for (int j = 0; j < columns; j++) {     // Inner loop for columns
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }

        // Creating 1D array of size rows * columns
        int[] array = new int[rows * columns];

        int index = 0; // Index for 1D array

        // Copying elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {             // Loop for rows
            for (int j = 0; j < columns; j++) {     // Loop for columns
                array[index] = matrix[i][j];       // Copy element
                index++;                           // Move to next index
            }
        }

        // Displaying the 1D array
        System.out.println("\nElements in the 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
