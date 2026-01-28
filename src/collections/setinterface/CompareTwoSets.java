package collections.setinterface;

/*
 * This program checks whether two sets contain the same elements
 * regardless of their order using the equals() method of Set.
 */
import java.util.*;

public class CompareTwoSets {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Check if both sets are equal
        boolean isEqual = set1.equals(set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are both sets equal? " + isEqual);
    }
}

