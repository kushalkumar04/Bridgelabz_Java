package collections.listinterface;

/*
 * This program finds the frequency of each string in a list
 * and stores the result in a Map<String, Integer>.
 * It uses a HashMap to count how many times each element appears.
 */
import java.util.*;

public class FrequencyOfElements {

    public static void main(String[] args) {

        // Input list
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");

        // Map to store frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each element
        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        // Display result
        System.out.println("Input List: " + list);
        System.out.println("Frequency Map: " + frequencyMap);
    }
}
