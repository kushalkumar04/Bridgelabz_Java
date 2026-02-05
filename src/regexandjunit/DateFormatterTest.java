package regexandjunit;

/*
 * JUnit test class for DateFormatter.
 * It tests valid and invalid date inputs.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
    }

    @Test
    void testAnotherValidDate() {
        assertEquals("01-01-2023", formatter.formatDate("2023-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> formatter.formatDate("12/25/2024"));
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class,
                () -> formatter.formatDate("2024-13-40"));
    }
}
