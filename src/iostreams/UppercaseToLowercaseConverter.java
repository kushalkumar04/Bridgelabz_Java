package iostreams;

/*
 * Class Name: UppercaseToLowercaseConverter
 *
 * Description:
 * This class demonstrates the use of character-based filter streams
 * in Java to read text from a file, convert all uppercase letters
 * to lowercase, and write the modified content into another file.
 *
 * FileReader and FileWriter are used for character stream handling,
 * while BufferedReader and BufferedWriter improve efficiency.
 *
 * The program safely handles character encoding by relying on the
 * platform's default charset (commonly UTF-8 in modern systems).
 *
 * Proper exception handling is implemented to manage IO-related errors.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {

        // Source and destination file paths
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        // Declare readers and writers
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Create FileReader and wrap it with BufferedReader
            reader = new BufferedReader(new FileReader(sourceFile));

            // Create FileWriter and wrap it with BufferedWriter
            writer = new BufferedWriter(new FileWriter(destinationFile));

            int character;

            // Read file character by character
            while ((character = reader.read()) != -1) {

                // Convert character to lowercase
                char lowerChar = Character.toLowerCase((char) character);

                // Write converted character to destination file
                writer.write(lowerChar);
            }

            System.out.println("File converted successfully (Uppercase → Lowercase).");

        } catch (IOException e) {
            // Handle file read/write exceptions
            System.out.println("Error occurred while processing the files.");
        } finally {
            try {
                // Close BufferedReader
                if (reader != null) {
                    reader.close();
                }

                // Close BufferedWriter
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                // Handle closing errors
                System.out.println("Error while closing resources.");
            }
        }
    }
}
