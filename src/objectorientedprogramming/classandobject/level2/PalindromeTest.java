package objectorientedprogramming.classandobject.level2;

/*
 * This class checks whether a given string is a palindrome.
 * A palindrome is a word or sentence that reads the same
 * forward and backward (for example: "madam", "level").
 * It contains methods to verify the palindrome and display the result.
 */
class PalindromeChecker {

    // Attribute to store the text to be checked
    String text;

    // Method to check if the given text is a palindrome
    public boolean isPalindrome() {
        String reversed = "";

        // Reverse the original string
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        // Compare original string with reversed string
        return text.equalsIgnoreCase(reversed);
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a Palindrome.");
        } else {
            System.out.println(text + " is not a Palindrome.");
        }
    }
}

/*
 * This class contains the main method to create a PalindromeChecker
 * object and test the palindrome functionality.
 */
public class PalindromeTest {

    public static void main(String[] args) {

        // Create an object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        // Assign a value to the text attribute
        checker.text = "Madam";

        // Display whether the text is a palindrome or not
        checker.displayResult();
    }
}
