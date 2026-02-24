package designpatterns;

/*
 * This program demonstrates the Abstract Factory Design Pattern.
 * It provides an interface (VehicleFactory) for creating families of related objects
 * (Car and Bike) without specifying their concrete classes.
 * The client interacts only with factory interfaces, ensuring loose coupling.
 */

interface Car {
    void manufacture(); // Method to manufacture car
}

interface Bike {
    void manufacture(); // Method to manufacture bike
}

class Sedan implements Car {

    @Override
    public void manufacture() { // Sedan implementation
        System.out.println("Manufacturing Sedan Car...");
    }
}

class SUV implements Car {

    @Override
    public void manufacture() { // SUV implementation
        System.out.println("Manufacturing SUV Car...");
    }
}

class SportsBike implements Bike {

    @Override
    public void manufacture() { // SportsBike implementation
        System.out.println("Manufacturing Sports Bike...");
    }
}

class NormalBike implements Bike {

    @Override
    public void manufacture() { // NormalBike implementation
        System.out.println("Manufacturing Normal Bike...");
    }
}

abstract class VehicleFactory {

    abstract Car createCar(String type); // Abstract method to create Car

    abstract Bike createBike(String type); // Abstract method to create Bike
}

class CarFactory extends VehicleFactory {

    @Override
    Car createCar(String type) { // Create car based on type
        if (type.equalsIgnoreCase("SEDAN")) {
            return new Sedan();
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV();
        }
        return null;
    }

    @Override
    Bike createBike(String type) { // CarFactory does not create bikes
        return null;
    }
}

class BikeFactory extends VehicleFactory {

    @Override
    Car createCar(String type) { // BikeFactory does not create cars
        return null;
    }

    @Override
    Bike createBike(String type) { // Create bike based on type
        if (type.equalsIgnoreCase("SPORTS")) {
            return new SportsBike();
        } else if (type.equalsIgnoreCase("NORMAL")) {
            return new NormalBike();
        }
        return null;
    }
}

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        VehicleFactory carFactory = new CarFactory(); // Client uses CarFactory
        Car car1 = carFactory.createCar("SEDAN");
        car1.manufacture();

        VehicleFactory bikeFactory = new BikeFactory(); // Client uses BikeFactory
        Bike bike1 = bikeFactory.createBike("SPORTS");
        bike1.manufacture();
    }
}