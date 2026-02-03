package exceptions;

/*
 * This program demonstrates the use of try-with-resources.
 * It reads multiple files safely using BufferedReader.
 * All file resources are automatically closed after processing,
 * even if an IOException occurs.
 */
import java.io.*;
import java.util.*;

public class FileProcessor {

    // Method to process multiple files
    public void processFiles(List<String> filePaths) {

        for (String path : filePaths) {

            // try-with-resources ensures BufferedReader is closed automatically
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

                String line;
                System.out.println("Reading file: " + path);

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }

            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        List<String> files = Arrays.asList(
                "file1.txt",
                "file2.txt",
                "file3.txt"
        );

        FileProcessor processor = new FileProcessor();
        processor.processFiles(files);
    }
}
