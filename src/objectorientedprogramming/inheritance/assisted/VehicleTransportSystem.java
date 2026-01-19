package objectorientedprogramming.inheritance.assisted;
/*
 * Vehicle Transport System
 *
 * Demonstrates inheritance and polymorphism using an array.
 * Vehicle is the superclass.
 * Car, Truck, and Motorcycle are subclasses.
 * Polymorphism allows dynamic method calls.
 */

class Vehicle {

    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car subclass
class Car extends Vehicle {

    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass
class Truck extends Vehicle {

    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {

    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
    }
}

public class VehicleTransportSystem {

    public static void main(String[] args) {

        // Polymorphism using Vehicle array
        Vehicle[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(120, "Diesel", 10),
                new Motorcycle(150, "Petrol", true)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}