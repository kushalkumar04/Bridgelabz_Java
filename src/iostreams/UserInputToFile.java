package iostreams;
/*
 * Class Name: UserInputToFile
 *
 * Description:
 * This class demonstrates how to read user input from the console
 * using BufferedReader and store the collected information into
 * a text file using FileWriter.
 *
 * The program asks the user to enter their name, age, and favorite
 * programming language, then writes this data into a file.
 *
 * Proper exception handling is implemented to handle input/output
 * related errors.
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputToFile {

    public static void main(String[] args) {

        // File name where user data will be stored
        String fileName = "user_details.txt";

        // Declare BufferedReader
        BufferedReader br = null;
        FileWriter writer = null;

        try {
            // Create BufferedReader to read input from console
            br = new BufferedReader(new InputStreamReader(System.in));

            // Ask user for name
            System.out.print("Enter your name: ");
            String name = br.readLine();

            // Ask user for age
            System.out.print("Enter your age: ");
            String age = br.readLine();

            // Ask user for favorite programming language
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Create FileWriter to write data into file
            writer = new FileWriter(fileName);

            // Write user information into the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            // Display success message
            System.out.println("\nUser details saved successfully.");

        } catch (IOException e) {
            // Handle input/output exceptions
            System.out.println("Error occurred while reading input or writing to file.");
        } finally {
            try {
                // Close BufferedReader if opened
                if (br != null) {
                    br.close();
                }

                // Close FileWriter if opened
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                // Handle exception while closing resources
                System.out.println("Error while closing resources.");
            }
        }
    }
}
