package regexandjunit;

/*
 * JUnit test class to verify exception handling
 * in the divide method.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    Divider divider = new Divider();

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> divider.divide(10, 0));
    }

    @Test
    void testValidDivision() {
        assertEquals(5, divider.divide(10, 2));
    }
}
