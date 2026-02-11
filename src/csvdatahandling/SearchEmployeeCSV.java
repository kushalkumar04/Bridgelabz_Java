package csvdatahandling;

/*
 * This program reads an employees.csv file
 * and searches for an employee by name.
 * If found, it prints the department and salary.
 */
import java.io.*;
import java.util.Scanner;

public class SearchEmployeeCSV {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = input.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String id = parts[0];
                String name = parts[1];
                String department = parts[2];
                String salary = parts[3];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        input.close();
    }
}
