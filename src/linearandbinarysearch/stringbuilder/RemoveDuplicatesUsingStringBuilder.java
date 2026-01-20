package linearandbinarysearch.stringbuilder;
/*
 * This program removes duplicate characters from a string
 * using StringBuilder while preserving the original order.
 * A HashSet is used to keep track of characters that have
 * already been added to the result.
 */
import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {

    public static void main(String[] args) {

        // Input string
        String input = "programming";

        // Create a HashSet to store unique characters
        HashSet<Character> seen = new HashSet<>();

        // Create a StringBuilder to build the result string
        StringBuilder result = new StringBuilder();

        // Traverse each character in the input string
        for (char ch : input.toCharArray()) {

            // If character is not already in the HashSet, add it
            if (!seen.contains(ch)) {
                seen.add(ch);          // Mark character as seen
                result.append(ch);    // Append character to result
            }
        }

        // Convert StringBuilder to String
        String output = result.toString();

        // Display result
        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + output);
    }
}
