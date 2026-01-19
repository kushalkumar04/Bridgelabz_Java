package objectorientedprogramming.encapsulation;
/*
 * Ride-Hailing Application
 *
 * Features:
 * - Abstract Transport class
 * - Interface GPS
 * - Subclasses SedanCar, SportsBike, MiniAuto
 * - Encapsulation
 * - Polymorphism via Transport list
 */

import java.util.ArrayList;
import java.util.List;

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract class representing a general transport vehicle
abstract class Transport {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Transport(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getter methods
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // Display vehicle details
    public void displayTransportDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per KM: " + ratePerKm);
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);
}

// SedanCar class extending Transport and implementing GPS
class SedanCar extends Transport implements GPS {
    private String location;

    public SedanCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String location) { this.location = location; }
}

// SportsBike class extending Transport and implementing GPS
class SportsBike extends Transport implements GPS {
    private String location;

    public SportsBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String location) { this.location = location; }
}

// MiniAuto class extending Transport and implementing GPS
class MiniAuto extends Transport implements GPS {
    private String location;

    public MiniAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String location) { this.location = location; }
}

// Main class for the ride-hailing application
public class RideHailingApp {
    public static void main(String[] args) {
        List<Transport> transports = new ArrayList<>();

        SedanCar car = new SedanCar("V001", "Alice", 10);
        SportsBike bike = new SportsBike("V002", "Bob", 5);
        MiniAuto auto = new MiniAuto("V003", "Charlie", 7);

        car.updateLocation("Downtown");
        bike.updateLocation("Airport");
        auto.updateLocation("Mall");

        transports.add(car);
        transports.add(bike);
        transports.add(auto);

        for (Transport t : transports) {
            t.displayTransportDetails();
            System.out.println("Fare for 10 KM: " + t.calculateFare(10));
            if (t instanceof GPS) System.out.println("Current Location: " + ((GPS) t).getCurrentLocation());
            System.out.println("---------------------------------");
        }
    }
}