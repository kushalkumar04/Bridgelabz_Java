package collections.queueinterface;

/*
 * This program generates the first N binary numbers using a Queue.
 * It uses a BFS-like approach by appending 0 and 1 to previous values.
 * Example: For N = 5, output will be [1, 10, 11, 100, 101].
 */
import java.util.*;

public class GenerateBinaryNumbers {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;
        List<String> binaryNumbers = generateBinary(n);

        System.out.println("First " + n + " Binary Numbers: " + binaryNumbers);
    }
}
