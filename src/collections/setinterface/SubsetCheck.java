package collections.setinterface;

/*
 * This program checks whether one set is a subset of another set.
 * It uses the containsAll() method of Set.
 * If all elements of Set1 are present in Set2, it returns true.
 * Otherwise, it returns false.
 */
import java.util.*;

public class SubsetCheck {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Check if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}

