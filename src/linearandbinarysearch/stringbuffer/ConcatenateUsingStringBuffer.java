package linearandbinarysearch.stringbuffer;

/*
 * This program demonstrates how to concatenate multiple strings
 * efficiently using the StringBuffer class.
 * StringBuffer is mutable, so it is faster than using normal
 * String concatenation inside loops.
 */
public class ConcatenateUsingStringBuffer {

    public static void main(String[] args) {

        // Array of strings to be concatenated
        String[] words = {"Java", " ", "is", " ", "powerful", " ", "and", " ", "fast"};

        // Create a StringBuffer object
        StringBuffer buffer = new StringBuffer();

        // Append each string from the array to the StringBuffer
        for (String word : words) {
            buffer.append(word);
        }

        // Convert StringBuffer to String
        String result = buffer.toString();

        // Display the concatenated result
        System.out.println("Concatenated String: " + result);
    }
}

