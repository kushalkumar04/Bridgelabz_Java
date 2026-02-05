package regexandjunit;
/*
 * This class provides basic string utility methods
 * such as reversing a string, checking if it is a palindrome,
 * and converting it to uppercase.
 */
public class StringUtils {

    // Reverse the given string
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Check if the string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Convert string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
