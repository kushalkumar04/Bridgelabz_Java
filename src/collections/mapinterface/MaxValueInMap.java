package collections.mapinterface;

/*
 * This program finds the key with the highest value
 * from a Map<String, Integer>.
 * It iterates through the map and tracks the maximum value.
 */
import java.util.*;

public class MaxValueInMap {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Map: " + map);
        System.out.println("Key with highest value: " + maxKey);
    }
}
