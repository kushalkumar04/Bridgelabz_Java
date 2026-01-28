package collections.listinterface;

/*
 * This program rotates the elements of a List by a given number
 * of positions to the left without using built-in rotate methods.
 * Example: [10, 20, 30, 40, 50] rotated by 2 becomes [30, 40, 50, 10, 20].
 */
import java.util.*;

public class RotateListExample {

    // Method to rotate list by k positions
    public static <T> void rotateLeft(List<T> list, int k) {
        int n = list.size();
        k = k % n; // Handle rotations greater than size

        for (int i = 0; i < k; i++) {
            T first = list.remove(0);
            list.add(first);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        System.out.println("Original List: " + list);
        rotateLeft(list, rotateBy);
        System.out.println("Rotated List: " + list);
    }
}
