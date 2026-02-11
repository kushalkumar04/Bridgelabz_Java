package csvdatahandling;

/*
 * This program merges two CSV files based on student ID.
 * students1.csv contains: ID, Name, Age
 * students2.csv contains: ID, Marks, Grade
 * The result is written to merged_students.csv
 * with all student details combined.
 */
import java.io.*;
import java.util.*;

class StudentInfo {
    String name;
    int age;

    public StudentInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class StudentMarks {
    double marks;
    String grade;

    public StudentMarks(double marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }
}

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, StudentInfo> infoMap = new HashMap<>();
        Map<String, StudentMarks> marksMap = new HashMap<>();

        // Read first CSV (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                infoMap.put(parts[0],
                        new StudentInfo(parts[1],
                                Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            System.out.println("Error reading students1.csv: " + e.getMessage());
        }

        // Read second CSV (ID, Marks, Grade)
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                marksMap.put(parts[0],
                        new StudentMarks(
                                Double.parseDouble(parts[1]),
                                parts[2]));
            }
        } catch (IOException e) {
            System.out.println("Error reading students2.csv: " + e.getMessage());
        }

        // Write merged output
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Write header
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (String id : infoMap.keySet()) {
                StudentInfo info = infoMap.get(id);
                StudentMarks marks = marksMap.get(id);

                if (marks != null) {
                    bw.write(id + "," +
                            info.name + "," +
                            info.age + "," +
                            marks.marks + "," +
                            marks.grade);
                    bw.newLine();
                }
            }

            System.out.println("Merged file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing merged CSV: " + e.getMessage());
        }
    }
}
