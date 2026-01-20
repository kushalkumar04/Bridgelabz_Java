package linearandbinarysearch.binarysearch;

/*
 * This program finds the rotation point (index of the smallest element)
 * in a rotated sorted array using Binary Search.
 * The rotation point indicates how many times the array was rotated.
 */
public class RotationPointBinarySearch {

    public static void main(String[] args) {

        // Example rotated sorted array
        int[] arr = {15, 18, 2, 3, 6, 12};

        // Find the index of the smallest element
        int index = findRotationPoint(arr);

        // Display result
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);
    }

    /*
     * This method uses Binary Search to find the index
     * of the smallest element in a rotated sorted array.
     */
    public static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        // Continue searching while the range is not reduced to one element
        while (left < right) {

            // Find the middle index
            int mid = left + (right - left) / 2;

            // If middle element is greater than the rightmost element,
            // the smallest value must be in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, the smallest value is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // When left == right, it points to the smallest element
        return left;
    }
}
