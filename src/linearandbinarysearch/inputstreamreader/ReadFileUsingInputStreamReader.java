package linearandbinarysearch.inputstreamreader;

/*
 * This program demonstrates how to convert a byte stream
 * into a character stream using InputStreamReader.
 * It reads a file encoded in UTF-8 and prints its content
 * line by line to the console.
 */
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadFileUsingInputStreamReader {

    public static void main(String[] args) {

        // Path of the file to be read
        String filePath = "sample.txt";

        try {
            // Create FileInputStream to read raw bytes from the file
            FileInputStream fis = new FileInputStream(filePath);

            // Convert byte stream to character stream using UTF-8 encoding
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            // Wrap InputStreamReader with BufferedReader for efficient reading
            BufferedReader reader = new BufferedReader(isr);

            String line;

            // Read and print the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the reader (also closes InputStreamReader and FileInputStream)
            reader.close();
        }
        catch (IOException e) {
            // Handle file not found, encoding, or read errors
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
