package objectorientedprogramming.classandobject.level2;

/*
 * This class represents a Student with details such as
 * name, roll number, and marks. It contains methods to
 * calculate the grade based on marks and to display
 * the complete student report.
 */
class Student {

    // Instance variables to store student details
    String name;
    int rollNumber;
    int marks;

    // Method to calculate grade based on marks
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "Fail";
        }
    }

    // Method to display student details and grade
    public void displayReport() {
        System.out.println("Student Name  : " + name);
        System.out.println("Roll Number   : " + rollNumber);
        System.out.println("Marks         : " + marks);
        System.out.println("Grade         : " + calculateGrade());
    }
}

/*
 * This class contains the main method to create a Student object
 * and generate the student report.
 */
public class StudentReport {

    public static void main(String[] args) {

        // Create an object of Student class
        Student student = new Student();

        // Assign values to student attributes
        student.name = "Kushal Kumar";
        student.rollNumber = 101;
        student.marks = 88;

        // Display the complete student report
        student.displayReport();
    }
}
