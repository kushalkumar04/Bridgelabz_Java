package collections.setinterface;

/*
 * This program converts a HashSet of integers into
 * a sorted List in ascending order.
 */
import java.util.*;

public class SetToSortedList {

    public static void main(String[] args) {

        // Input Set
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert Set to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the List
        Collections.sort(list);

        // Display result
        System.out.println("Original Set: " + set);
        System.out.println("Sorted List: " + list);
    }
}
