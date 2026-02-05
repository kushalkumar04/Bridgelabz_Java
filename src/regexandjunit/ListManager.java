package regexandjunit;

/*
 * This class manages basic operations on a list of integers.
 * It supports adding elements, removing elements,
 * and retrieving the size of the list.
 */
import java.util.List;

public class ListManager {

    // Add element to list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Remove element from list
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // Get size of list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}
