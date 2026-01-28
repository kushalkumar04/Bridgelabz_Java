package collections.listinterface;

/*
 * This program finds the Nth element from the end of a LinkedList
 * using the two-pointer technique without calculating the size.
 */
import java.util.*;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.hasNext())
                fast.next();
            else
                return null;
        }

        // Move both until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // Slow now points to Nth from end
        return slow.next();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from end: " + result); // Output: D
    }
}
