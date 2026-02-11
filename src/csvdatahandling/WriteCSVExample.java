package csvdatahandling;

/*
 * This program writes employee details to a CSV file.
 * It creates a file named "employees.csv"
 * and writes 5 employee records into it.
 */
import java.io.*;
import java.util.*;

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
}

public class WriteCSVExample {

    public static void main(String[] args) {

        String filePath = "employees.csv";

        List<Employee> employees = Arrays.asList(
                new Employee("E101", "Alice", "HR", 50000),
                new Employee("E102", "Bob", "IT", 65000),
                new Employee("E103", "Carol", "Finance", 70000),
                new Employee("E104", "David", "IT", 72000),
                new Employee("E105", "Eve", "Marketing", 55000)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Write header
            writer.write("ID,Name,Department,Salary");
            writer.newLine();

            // Write employee records
            for (Employee emp : employees) {
                writer.write(emp.id + "," +
                        emp.name + "," +
                        emp.department + "," +
                        emp.salary);
                writer.newLine();
            }

            System.out.println("CSV file written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
