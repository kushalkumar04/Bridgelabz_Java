package linearandbinarysearch.filereader;

/*
 * This program reads a text file using FileReader and BufferedReader
 * and counts how many times a specific word appears in the file.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordCountInFile {

    public static void main(String[] args) {

        // File path
        String filePath = "sample.txt";

        // Word to be searched
        String targetWord = "java";

        // Counter to store number of occurrences
        int count = 0;

        try {
            // Create FileReader object to read the file
            FileReader fileReader = new FileReader(filePath);

            // Wrap FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Split each line into words using space as delimiter
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++; // Increase count if word matches
                    }
                }
            }

            // Close the BufferedReader
            bufferedReader.close();

            // Display the result
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");

        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
