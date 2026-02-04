package exceptions;

/*
 * This program demonstrates try-with-resources using multiple resources.
 * It reads data from two input files and writes the combined content
 * into a third output file, ensuring all resources are closed properly.
 */
import java.io.*;

public class MultipleResourcesExample {

    public static void main(String[] args) {

        String file1 = "input1.txt";
        String file2 = "input2.txt";
        String outputFile = "output.txt";

        // try-with-resources with multiple resources
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            // Read from first file
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Read from second file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files combined successfully.");

        } catch (IOException e) {
            System.out.println("Error processing files.");
        }
    }
}
