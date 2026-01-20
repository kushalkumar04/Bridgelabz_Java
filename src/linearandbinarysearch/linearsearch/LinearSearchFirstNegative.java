package linearandbinarysearch.linearsearch;

/*
 * This program uses Linear Search to find the first
 * negative number in an integer array.
 * It returns the index of the first negative number.
 * If no negative number is found, it returns -1.
 */
public class LinearSearchFirstNegative {

    public static void main(String[] args) {

        // Sample array
        int[] numbers = {5, 8, 3, -4, 7, -2, 10};

        // Call the method to find first negative number
        int index = findFirstNegative(numbers);

        // Display result
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    /*
     * This method performs linear search to find
     * the first negative number in the array.
     */
    public static int findFirstNegative(int[] arr) {

        // Traverse the array from the beginning
        for (int i = 0; i < arr.length; i++) {

            // Check if the current element is negative
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }

        // If no negative number is found
        return -1;
    }
}
