package collections.listinterface;

/*
 * This program removes duplicate elements from a list
 * while preserving the original order of elements.
 * It uses a LinkedHashSet to maintain insertion order.
 */
import java.util.*;

public class RemoveDuplicatesPreserveOrder {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        // LinkedHashSet preserves insertion order and removes duplicates
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);

        // Convert back to List
        List<Integer> result = new ArrayList<>(uniqueSet);

        System.out.println("Original List: " + list);
        System.out.println("After Removing Duplicates: " + result);
    }
}
