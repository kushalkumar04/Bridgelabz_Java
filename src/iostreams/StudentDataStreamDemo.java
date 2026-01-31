package iostreams;

/*
 * Class Name: StudentDataStreamDemo
 *
 * Description:
 * This class demonstrates the use of DataOutputStream and
 * DataInputStream in Java to store and retrieve primitive
 * data types in a binary file.
 *
 * Student details such as roll number (int), name (String),
 * and GPA (double) are written into a file and later read
 * back in the same order.
 *
 * Proper resource management and exception handling are
 * implemented to ensure safe file operations.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDataStreamDemo {

    public static void main(String[] args) {

        // Binary file name
        String fileName = "student.dat";

        /* ------------------ Writing Data ------------------ */
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            // Student details
            int rollNumber = 101;
            String name = "Kushal";
            double gpa = 8.75;

            // Write primitive data to binary file
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing student data.");
        }

        /* ------------------ Reading Data ------------------ */
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            // Read data in the same order as written
            int readRoll = dis.readInt();
            String readName = dis.readUTF();
            double readGpa = dis.readDouble();

            // Display retrieved data
            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number : " + readRoll);
            System.out.println("Name        : " + readName);
            System.out.println("GPA         : " + readGpa);

        } catch (IOException e) {
            System.out.println("Error while reading student data.");
        }
    }
}
