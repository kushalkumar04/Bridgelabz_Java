package linearandbinarysearch.inputstreamreader;

/*
 * This program reads user input from the console using InputStreamReader
 * and writes each line into a file. The input is written line by line
 * until the user types "exit".
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleToFileUsingInputStreamReader {

    public static void main(String[] args) {

        try {
            // Create InputStreamReader to read input from keyboard (byte to character stream)
            InputStreamReader isr = new InputStreamReader(System.in);

            // Wrap InputStreamReader with BufferedReader for line-by-line input
            BufferedReader reader = new BufferedReader(isr);

            // Create FileWriter to write data into a file
            FileWriter writer = new FileWriter("output.txt", true); // true for append mode

            String inputLine;

            System.out.println("Enter text (type 'exit' to stop):");

            // Read input until user types "exit"
            while (true) {
                inputLine = reader.readLine();

                if (inputLine.equalsIgnoreCase("exit")) {
                    break; // Stop reading input
                }

                // Write the input to the file followed by a new line
                writer.write(inputLine + "\n");
            }

            // Close the writer
            writer.close();

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            // Handle input/output errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}

