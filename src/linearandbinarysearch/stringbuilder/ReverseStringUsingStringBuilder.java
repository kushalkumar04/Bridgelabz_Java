package linearandbinarysearch.stringbuilder;

/*
 * This program demonstrates how to reverse a string
 * using the StringBuilder class in Java.
 * It uses the built-in reverse() method of StringBuilder.
 */
public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        // Input string
        String input = "hello";

        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(input);

        // Reverse the string using StringBuilder's reverse() method
        sb.reverse();

        // Convert StringBuilder back to String
        String reversed = sb.toString();

        // Display the result
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }
}

