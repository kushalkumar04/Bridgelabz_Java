package exceptions;

/*
 * This program demonstrates handling of a checked exception (IOException).
 * It tries to read a file named "data.txt".
 * If the file exists, its contents are printed.
 * If the file does not exist, a user-friendly message is displayed.
 */
import java.io.*;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;

            // Read and print file contents
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        }
        catch (IOException e) {
            // Handle file not found or read error
            System.out.println("File not found");
        }
    }
}
