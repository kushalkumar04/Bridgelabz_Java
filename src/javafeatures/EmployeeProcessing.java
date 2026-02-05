package javafeatures;

/*
 * This program processes a list of Employee objects using
 * Java 8 Stream API. It performs filtering, sorting,
 * grouping, and aggregation operations.
 */
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + department + " | $" + salary;
    }
}

public class EmployeeProcessing {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 75000),
                new Employee(3, "Carol", "HR", 85000),
                new Employee(4, "David", "Engineering", 95000),
                new Employee(5, "Eve", "Finance", 70000)
        );

        // 1 & 2: Filter Engineering employees with salary > 80000 and sort descending
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        // 3: Group by department
        Map<String, List<Employee>> grouped =
                filteredSorted.stream()
                        .collect(Collectors.groupingBy(e -> e.department));

        System.out.println("\nGrouped by Department:");
        grouped.forEach((dept, list) -> {
            System.out.println(dept + ": " + list);
        });

        // 4: Average salary per department
        Map<String, Double> avgSalary =
                filteredSorted.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.department,
                                Collectors.averagingDouble(e -> e.salary)
                        ));

        System.out.println("\nAverage Salary by Department:");
        avgSalary.forEach((dept, avg) ->
                System.out.println(dept + ": $" + avg));
    }
}
