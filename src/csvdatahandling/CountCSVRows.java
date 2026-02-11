package csvdatahandling;

/*
 * This program reads a CSV file and counts
 * the number of records excluding the header row.
 */
import java.io.*;

public class CountCSVRows {

    public static void main(String[] args) {

        String filePath = "students.csv"; // CSV file path
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header row
            br.readLine();

            // Count remaining rows
            while (br.readLine() != null) {
                count++;
            }

            System.out.println("Number of records: " + count);

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
