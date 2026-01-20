package linearandbinarysearch.binarysearch;

/*
 * This program searches for a target value in a 2D sorted matrix
 * using Binary Search by treating the matrix as a flattened 1D array.
 * If the target is found, it returns true; otherwise, it returns false.
 */
public class SearchInTwoDMatrix {

    public static void main(String[] args) {

        // Given 2D sorted matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        // Search for the target in the matrix
        boolean found = searchMatrix(matrix, target);

        // Display result
        if (found) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }

    /*
     * This method performs Binary Search on a 2D matrix
     * by converting it conceptually into a 1D array.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Define search space in terms of 1D indices
        int left = 0;
        int right = rows * cols - 1;

        // Perform Binary Search
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D row and column
            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];

            // Check if the middle element is the target
            if (midValue == target) {
                return true;
            }
            // If target is smaller, search left half
            else if (target < midValue) {
                right = mid - 1;
            }
            // If target is larger, search right half
            else {
                left = mid + 1;
            }
        }

        // Target not found
        return false;
    }
}
