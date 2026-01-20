package linearandbinarysearch.binarysearch;

/*
 * This program finds a peak element in an array using
 * Binary Search. A peak element is one that is greater
 * than its immediate neighbors.
 * If multiple peaks exist, any one peak is returned.
 */
public class FindPeakElement {

    public static void main(String[] args) {

        // Example array
        int[] arr = {1, 3, 20, 4, 1, 0};

        // Find a peak element
        int peakIndex = findPeak(arr);

        // Display result
        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }

    /*
     * This method uses Binary Search to find a peak element.
     */
    public static int findPeak(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int n = arr.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            boolean isLeftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean isRightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (isLeftSmaller && isRightSmaller) {
                return mid; // Peak found
            }

            // If left neighbor is greater, then peak lies on the left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else peak lies on the right side
            else {
                left = mid + 1;
            }
        }

        return -1; // Should never reach here if array is valid
    }
}
