package objectorientedprogramming.classandobject.level1;

/*
 * This program defines an Employee class with attributes such as
 * name, id, and salary. It also contains a method to display
 * the employee details in a readable format.
 */
class Employee {

    // Instance variables to store employee details
    String name;
    int id;
    double salary;

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name  : " + name);
        System.out.println("Employee ID    : " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

/*
 * This class contains the main method to create an Employee object
 * and call the display method.
 */
public class EmployeeDetails {

    public static void main(String[] args) {

        // Create an object of Employee class
        Employee emp = new Employee();

        // Assign values to the employee attributes
        emp.name = "Kushal Kumar";
        emp.id = 101;
        emp.salary = 50000;

        // Call the method to display employee details
        emp.displayDetails();
    }
}
