package csvdatahandling;

/*
 * This program reads an employees.csv file,
 * sorts the records by salary in descending order,
 * and prints the top 5 highest-paid employees.
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Employee {
    String id;
    String name;
    String department;
    double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}

public class SortCSVBySalary {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                employees.add(new Employee(
                        parts[0],
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3])
                ));
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        // Sort by salary descending and print top 5
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .limit(5)
                .forEach(System.out::println);
    }
}
