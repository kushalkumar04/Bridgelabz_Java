package regexandjunit;

/*
 * JUnit test class for ListManager.
 * It verifies add, remove, and size operations on the list.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, manager.getSize(list));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        manager.removeElement(list, 20);

        assertFalse(list.contains(20));
        assertEquals(2, manager.getSize(list));
    }

    @Test
    void testSizeUpdate() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        manager.addElement(list, 15);
        manager.removeElement(list, 5);

        assertEquals(1, manager.getSize(list));
    }
}
