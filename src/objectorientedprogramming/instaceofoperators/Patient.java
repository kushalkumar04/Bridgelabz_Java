
package objectorientedprogramming.instaceofoperators;
/*
 * Patient class demonstrates static, this, final, and instanceof
 */

public class Patient {

    // Static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // Final variable
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using this
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method
    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    // Method using instanceof
    void displayPatient(Object obj) {
        if (obj instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Sarah", 30, "Fever", 501);
        p1.displayPatient(p1);
        Patient.getTotalPatients();
    }
}
