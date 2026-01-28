package collections.setinterface;

/*
 * This program finds the symmetric difference of two sets.
 * Symmetric difference contains elements that are in either
 * of the sets but not in both.
 */
import java.util.*;

public class SymmetricDifferenceExample {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Create copies to avoid modifying original sets
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Symmetric Difference = Union - Intersection
        union.removeAll(intersection);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + union);
    }
}
