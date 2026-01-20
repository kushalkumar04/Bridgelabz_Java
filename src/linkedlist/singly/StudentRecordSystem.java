package linkedlist.singly;

/***************************************************************
 * This program manages student records using a Singly Linked List.
 * Each node stores:
 *   - Roll Number
 *   - Name
 *   - Age
 *   - Grade

 * The program supports:
 * 1. Insert at beginning, end, and specific position
 * 2. Delete by Roll Number
 * 3. Search by Roll Number
 * 4. Display all records
 * 5. Update Grade by Roll Number
 ***************************************************************/

class StudentNode {

    // Student details
    int rollNumber;
    String name;
    int age;
    char grade;

    // Reference to next node
    StudentNode next;

    // Constructor to initialize a student node
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

/*
 * This class implements all Singly Linked List operations
 * for managing student records.
 */
class StudentLinkedList {

    // Head of the linked list
    StudentNode head;

    // Insert at the beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void addAtEnd(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at a specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a student by Roll Number
    public void deleteByRoll(int roll) {
        if (head == null) return;

        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    // Search for a student by Roll Number
    public void search(int roll) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found:");
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Update grade by Roll Number
    public void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }

    // Helper method to print one student record
    private void displayStudent(StudentNode s) {
        System.out.println("---------------------------");
        System.out.println("Roll Number : " + s.rollNumber);
        System.out.println("Name        : " + s.name);
        System.out.println("Age         : " + s.age);
        System.out.println("Grade       : " + s.grade);
    }
}

/*
 * Main class to test the Student Record Management System
 */
public class StudentRecordSystem {

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        // Add students
        list.addAtBeginning(101, "Amit", 20, 'A');
        list.addAtEnd(102, "Kushal", 21, 'B');
        list.addAtEnd(103, "Ravi", 22, 'C');

        // Insert at position
        list.addAtPosition(2, 104, "Neha", 19, 'A');

        // Display all students
        System.out.println("All Student Records:");
        list.displayAll();

        // Search student
        list.search(102);

        // Update grade
        list.updateGrade(103, 'A');

        // Delete a student
        list.deleteByRoll(101);

        // Display after deletion
        System.out.println("\nAfter Deletion:");
        list.displayAll();
    }
}
