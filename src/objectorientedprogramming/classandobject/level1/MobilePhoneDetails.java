package objectorientedprogramming.classandobject.level1;

/*
 * This class represents a Mobile Phone with basic details
 * such as brand, model, and price. It contains a method
 * to display all the phone details in a readable format.
 */
class MobilePhone {

    // Instance variables to store mobile phone details
    String brand;
    String model;
    double price;

    // Method to display all mobile phone details
    public void displayDetails() {
        System.out.println("Mobile Brand : " + brand);
        System.out.println("Mobile Model : " + model);
        System.out.println("Mobile Price : INR " + price);
    }
}

/*
 * This class contains the main method to create a MobilePhone
 * object and call the display method.
 */
public class MobilePhoneDetails {

    public static void main(String[] args) {

        // Create an object of MobilePhone class
        MobilePhone phone = new MobilePhone();

        // Assign values to the phone attributes
        phone.brand = "Samsung";
        phone.model = "Galaxy S23";
        phone.price = 74999.0;

        // Display the mobile phone details
        phone.displayDetails();
    }
}
