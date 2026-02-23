package reflection;

/*
 * Uses Java Reflection API to display
 * constructors, methods, and fields
 * of a given class at runtime.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionClassInspector {

    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter fully qualified class name
        System.out.print("Enter fully qualified class name: ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically using Reflection
            Class<?> clazz = Class.forName(className);

            // Print class name
            System.out.println("\nClass Name: " + clazz.getName());

            // -------- Display Constructors --------
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // -------- Display Methods --------
            System.out.println("\n--- Methods ---");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // -------- Display Fields --------
            System.out.println("\n--- Fields ---");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            // Handle case when class is not found
            System.out.println("Class not found! Please enter a valid class name.");
        }

        // Close scanner to prevent resource leak
        scanner.close();
    }
}
