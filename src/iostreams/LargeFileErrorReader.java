package iostreams;

/*
 * Class Name: LargeFileErrorReader
 *
 * Description:
 * This class demonstrates efficient reading of a very large
 * text file (500MB or more) using BufferedReader.
 *
 * The program reads the file line by line instead of loading
 * the entire file into memory, making it suitable for large files.
 *
 * Only lines containing the word "error" (case-insensitive)
 * are printed to the console.
 *
 * Proper exception handling is implemented to handle
 * IO-related errors safely.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileErrorReader {

    public static void main(String[] args) {

        // Path of the large text file
        String filePath = "large_log_file.txt";

        // Declare BufferedReader
        BufferedReader reader = null;

        try {
            // Create BufferedReader for efficient line-by-line reading
            reader = new BufferedReader(new FileReader(filePath));

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                // Check if line contains "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error while reading the file.");
        } finally {
            try {
                // Close BufferedReader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // Handle closing errors
                System.out.println("Error while closing the file.");
            }
        }
    }
}

