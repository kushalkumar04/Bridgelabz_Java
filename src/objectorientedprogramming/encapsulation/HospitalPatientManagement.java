package objectorientedprogramming.encapsulation;
/*
 * Hospital Patient Management System
 *
 * Features:
 * - Abstract class Patient
 * - Interface MedicalRecord
 * - Subclasses InPatient and OutPatient
 * - Encapsulation for sensitive data
 * - Polymorphism via Patient list
 */

import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private ArrayList<String> records;

    public InPatient(String id, String name, int age, double roomCharge) {
        super(id, name, age);
        this.roomCharge = roomCharge;
        records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return roomCharge * 3; // Example: 3 days stay
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> records;

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
        records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for OutPatient:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient in = new InPatient("P001", "Alice", 30, 5000);
        OutPatient out = new OutPatient("P002", "Bob", 25, 1000);

        in.addRecord("Appendectomy surgery");
        out.addRecord("Flu treatment");

        patients.add(in);
        patients.add(out);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) ((MedicalRecord) p).viewRecords();
            System.out.println("---------------------------------");
        }
    }
}