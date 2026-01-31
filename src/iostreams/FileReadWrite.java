package iostreams;

/*
 * Class Name: FileReadWrite
 *
 * Description:
 * This class demonstrates basic file handling in Java.
 * It reads the contents of a source text file and writes
 * the same contents into a destination text file.
 *
 * The program uses FileInputStream and FileOutputStream
 * for reading and writing byte data.
 *
 * If the source file does not exist, an appropriate
 * error message is displayed.
 *
 * Exception handling is implemented using try-catch
 * blocks to handle IO related issues.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {

    public static void main(String[] args) {

        // Source file path
        String sourceFile = "source.txt";

        // Destination file path
        String destinationFile = "destination.txt";

        // Declare FileInputStream and FileOutputStream
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Create FileInputStream to read from source file
            fis = new FileInputStream(sourceFile);

            // Create FileOutputStream to write into destination file
            // If destination file does not exist, it will be created
            fos = new FileOutputStream(destinationFile);

            int data;

            // Read data byte by byte from source file
            while ((data = fis.read()) != -1) {
                // Write data byte by byte into destination file
                fos.write(data);
            }

            // Display success message
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            // Handles file not found and other IO exceptions
            System.out.println("Error: Source file does not exist or cannot be read.");
        } finally {
            try {
                // Close FileInputStream if opened
                if (fis != null) {
                    fis.close();
                }

                // Close FileOutputStream if opened
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                // Handle exception while closing streams
                System.out.println("Error while closing files.");
            }
        }
    }
}
