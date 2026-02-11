package csvdatahandling;

/*
 * This program reads a CSV file and validates
 * email and phone number fields using regex.
 * Invalid rows are printed with an error message.
 */
import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {

    public static void main(String[] args) {

        String filePath = "contacts.csv";

        // Regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            int lineNumber = 0;

            // Read header
            String header = br.readLine();
            lineNumber++;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                String[] parts = line.split(",");

                // Assuming CSV format: ID,Name,Email,Phone
                String email = parts[2];
                String phone = parts[3];

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid data at line " + lineNumber + ": " + line);

                    if (!emailValid) {
                        System.out.println("  → Invalid Email: " + email);
                    }
                    if (!phoneValid) {
                        System.out.println("  → Invalid Phone: " + phone);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
