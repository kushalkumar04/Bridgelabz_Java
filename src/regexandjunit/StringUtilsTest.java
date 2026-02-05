package regexandjunit;
/*
 * JUnit test class for StringUtils.
 * It tests reverse, palindrome check,
 * and uppercase conversion methods.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void testReverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));
    }

    @Test
    void testPalindromeTrue() {
        assertTrue(StringUtils.isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(StringUtils.isPalindrome("world"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", StringUtils.toUpperCase("java"));
    }
}
