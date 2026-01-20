package linearandbinarysearch.binarysearch;
/*
 * This program finds the first and last occurrence of a target element
 * in a sorted array using Binary Search.
 * If the element is not found, it returns -1 for both positions.
 */
public class FirstAndLastOccurrence {

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 7, 8, 8, 9};
        int target = 4;

        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        if (first == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First occurrence of " + target + " is at index: " + first);
            System.out.println("Last occurrence of " + target + " is at index: " + last);
        }
    }

    /*
     * This method finds the first occurrence of the target element
     * using modified Binary Search.
     */
    public static int findFirstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;        // Possible first occurrence found
                right = mid - 1;     // Continue searching on the left side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    /*
     * This method finds the last occurrence of the target element
     * using modified Binary Search.
     */
    public static int findLastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;        // Possible last occurrence found
                left = mid + 1;      // Continue searching on the right side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }
}

