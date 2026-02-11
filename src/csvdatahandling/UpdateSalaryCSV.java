package csvdatahandling;

/*
 * This program reads an employees.csv file,
 * increases the salary of employees in the IT department by 10%,
 * and writes the updated data to a new CSV file.
 */
import java.io.*;

public class UpdateSalaryCSV {

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            // Read and write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String id = parts[0];
                String name = parts[1];
                String department = parts[2];
                double salary = Double.parseDouble(parts[3]);

                // Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                // Write updated record
                bw.write(id + "," + name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("Updated CSV file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing CSV file: " + e.getMessage());
        }
    }
}
