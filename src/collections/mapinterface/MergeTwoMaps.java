package collections.mapinterface;

/*
 * This program merges two maps. If a key exists in both maps,
 * their values are added; otherwise, the key-value pair is kept as is.
 * Example: {A=1, B=2} and {B=3, C=4} → {A=1, B=5, C=4}
 */
import java.util.*;

public class MergeTwoMaps {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Result map
        Map<String, Integer> result = new HashMap<>(map1);

        // Merge map2 into result
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.put(entry.getKey(),
                    result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + result);
    }
}
