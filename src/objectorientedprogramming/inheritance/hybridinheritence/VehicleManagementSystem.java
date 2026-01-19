
package objectorientedprogramming.inheritance.hybridinheritence;
/*
 * Vehicle Management System
 *
 * Demonstrates hybrid inheritance.
 * Vehicle is the superclass.
 * Refuelable is an interface with refuel() method.
 * ElectricVehicle extends Vehicle.
 * PetrolVehicle extends Vehicle and implements Refuelable.
 */

// Superclass
class Vehicle {

    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Display basic vehicle info
    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Refuelable interface
interface Refuelable {
    void refuel();
}

// ElectricVehicle class
class ElectricVehicle extends Vehicle {

    int batteryCapacity; // in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    // Unique method for electric vehicles
    void charge() {
        System.out.println(model + " is charging its battery of " + batteryCapacity + " kWh.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle class implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {

    double fuelTankCapacity; // in liters

    PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    // Implement refuel method from interface
    @Override
    public void refuel() {
        System.out.println(model + " is refueling " + fuelTankCapacity + " liters of petrol.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}

public class VehicleManagementSystem {

    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        ev.displayInfo();
        ev.charge();
        System.out.println();

        pv.displayInfo();
        pv.refuel();
    }
}
