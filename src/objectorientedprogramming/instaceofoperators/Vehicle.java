
package objectorientedprogramming.instaceofoperators;
/*
 * Vehicle class demonstrates static, this, final, and instanceof
 */

public class Vehicle {

    // Static variable
    static double registrationFee = 2000;

    // Final variable
    final String registrationNumber;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Constructor using this
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // Method using instanceof
    void displayVehicle(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration No: " + registrationNumber);
            System.out.println("Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Mike", "Car", "REG123");
        Vehicle.updateRegistrationFee(2500);
        v1.displayVehicle(v1);
    }
}
