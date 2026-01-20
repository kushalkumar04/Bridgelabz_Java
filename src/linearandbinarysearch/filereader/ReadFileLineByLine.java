package linearandbinarysearch.filereader;

/*
 * This program reads a text file line by line using FileReader
 * and BufferedReader, and prints each line to the console.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {

        // Specify the file path
        String filePath = "sample.txt";

        try {
            // Create FileReader to read characters from the file
            FileReader fileReader = new FileReader(filePath);

            // Wrap FileReader with BufferedReader for efficient line-by-line reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read each line until the end of the file is reached
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);  // Print the current line
            }

            // Close the BufferedReader (this also closes FileReader)
            bufferedReader.close();
        }
        catch (IOException e) {
            // Handle file not found or read errors
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

