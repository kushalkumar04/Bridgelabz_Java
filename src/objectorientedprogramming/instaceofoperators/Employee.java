
package objectorientedprogramming.instaceofoperators;
/*
 * Employee class demonstrates static, this, final, and instanceof
 */

public class Employee {

    // Static variables
    static String companyName = "Tech Corp";
    static int totalEmployees = 0;

    // Final variable
    final int id;

    // Instance variables
    String name;
    String designation;

    // Constructor using this
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method using instanceof
    void displayEmployee(Object obj) {
        if (obj instanceof Employee) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 1, "Developer");
        e1.displayEmployee(e1);
        Employee.displayTotalEmployees();
    }
}
