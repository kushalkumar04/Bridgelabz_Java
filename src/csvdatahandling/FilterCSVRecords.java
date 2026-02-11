package csvdatahandling;

/*
 * This program reads a CSV file of student records
 * and prints only those students who scored
 * more than 80 marks.
 */
import java.io.*;

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

public class FilterCSVRecords {

    public static void main(String[] args) {

        String filePath = "students.csv";

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

                // Filter condition
                if (student.marks > 80) {
                    System.out.println(student);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
