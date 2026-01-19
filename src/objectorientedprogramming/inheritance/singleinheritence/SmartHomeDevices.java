package objectorientedprogramming.inheritance.singleinheritence;
/*
 * Smart Home Devices System
 *
 * Demonstrates single inheritance.
 * Device is the superclass containing general device information.
 * Thermostat is a subclass that adds temperature control features.
 */

class Device {

    // Common attributes for all smart devices
    String deviceId;
    String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

/*
 * Thermostat class extends Device
 *
 * Adds temperature control functionality
 * while inheriting basic device properties.
 */
class Thermostat extends Device {

    // Additional attribute for Thermostat
    double temperatureSetting;

    // Constructor using super keyword
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to include temperature details
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeDevices {

    public static void main(String[] args) {

        // Creating Thermostat object
        Thermostat thermostat = new Thermostat("TH-101", "ON", 22.5);

        thermostat.displayStatus();
    }
}