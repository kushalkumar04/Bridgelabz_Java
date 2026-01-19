
package objectorientedprogramming.inheritance.hierarchialinheritence;
/*
 * School System with Different Roles
 *
 * Demonstrates hierarchical inheritance.
 * Person is the superclass.
 * Teacher, Student, and Staff are subclasses.
 */

class Person {

    // Common attributes for all people
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

/*
 * Teacher class
 *
 * Represents a teacher with a subject specialization.
 */
class Teacher extends Person {

    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Method specific to Teacher
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

/*
 * Student class
 *
 * Represents a student with a grade.
 */
class Student extends Person {

    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Method specific to Student
    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

/*
 * Staff class
 *
 * Represents non-teaching staff with a department.
 */
class Staff extends Person {

    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Method specific to Staff
    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystemRoles {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Riya", 16, "10th Grade");
        Staff staff = new Staff("Raj", 35, "Administration");

        teacher.displayPersonDetails();
        teacher.displayRole();
        System.out.println();

        student.displayPersonDetails();
        student.displayRole();
        System.out.println();

        staff.displayPersonDetails();
        staff.displayRole();
    }
}
