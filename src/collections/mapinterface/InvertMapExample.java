package collections.mapinterface;

/*
 * This program inverts a Map<K, V> into a Map<V, List<K>>.
 * If multiple keys have the same value, they are grouped
 * together in a list for that value.
 * Example: {A=1, B=2, C=1} → {1=[A, C], 2=[B]}.
 */
import java.util.*;

public class InvertMapExample {

    public static void main(String[] args) {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();

            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }

        System.out.println("Original Map: " + inputMap);
        System.out.println("Inverted Map: " + invertedMap);
    }
}
