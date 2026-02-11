package csvdatahandling;

/*
 * This program reads a CSV file and converts each row
 * into a Student object. All Student objects are stored
 * in a List and then printed.
 */
import java.io.*;
import java.util.*;

class Student {
    String id;
    String name;
    int age;
    double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Marks: " + marks;
    }
}

public class CSVToStudentObjects {

    public static void main(String[] args) {

        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                Student student = new Student(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3])
                );

                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        // Print all students
        System.out.println("Student List:");
        students.forEach(System.out::println);
    }
}

