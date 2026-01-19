
package objectorientedprogramming.instaceofoperators;
/*
 * Student class demonstrates static, this, final, and instanceof
 */

public class Student {

    // Static variables
    static String universityName = "ABC University";
    static int totalStudents = 0;

    // Final variable
    final int rollNumber;

    // Instance variables
    String name;
    char grade;

    // Constructor using this
    Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    // Method using instanceof
    void displayStudent(Object obj) {
        if (obj instanceof Student) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Emma", 101, 'A');
        s1.displayStudent(s1);
        Student.displayTotalStudents();
    }
}
